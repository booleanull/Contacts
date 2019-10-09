package com.booleanull.featurecontacts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booleanull.core.data.Contact
import com.booleanull.core.di.AppInjectHelper
import com.booleanull.core.di.ViewModelFactory
import com.booleanull.core.di.injectViewModel
import com.booleanull.featurecontacts.di.DaggerContactsComponent
import com.booleanull.featurecontacts.utils.ContactsSorter
import com.booleanull.featurecontacts.utils.RecyclerDivider
import kotlinx.android.synthetic.main.fragment_contacts.*
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ContactsFragment : Fragment() {

    @Inject
    lateinit var cicerone: Cicerone<Router>

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: ContactsViewModel

    private lateinit var contactsAdapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

        DaggerContactsComponent
            .builder()
            .appComponent(AppInjectHelper.provideAppComponent(context!!.applicationContext))
            .build()
            .inject(this)

        viewModel = injectViewModel(viewModelFactory)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        initObservers()
        initAdapter()
    }

    private fun initObservers() {
        viewModel.getContacts().observe(this, Observer {
            updateContacts(it)
        })
    }

    private fun initAdapter() {
        contactsAdapter = ContactsAdapter(cicerone)
        recycler.setHasFixedSize(true)
        recycler.addItemDecoration(
            RecyclerDivider(
                ContextCompat.getColor(
                    context!!,
                    R.color.colorGray
                )
            )
        )
        recycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recycler.adapter = contactsAdapter
    }

    private fun initListeners() {
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.sort_ascending -> {
                    viewModel.setContactList(ContactsSorter.sortListAscending(contactsAdapter.contacts.toMutableList()))
                    true
                }
                R.id.sort_descending -> {
                    viewModel.setContactList(ContactsSorter.sortListDescending(contactsAdapter.contacts.toMutableList()))
                    true
                }
                else -> false
            }
        }
    }

    private fun updateContacts(list: List<Contact>) {
        val contactDiffUtilCallback =
            ContactsAdapter.ContactDiffUtilCallback(contactsAdapter.contacts, list)
        val diffResult = DiffUtil.calculateDiff(contactDiffUtilCallback)

        contactsAdapter.contacts = list
        diffResult.dispatchUpdatesTo(contactsAdapter)
    }
}