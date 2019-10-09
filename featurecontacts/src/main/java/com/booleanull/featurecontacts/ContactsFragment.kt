package com.booleanull.featurecontacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booleanull.core.data.Contact
import kotlinx.android.synthetic.main.fragment_contacts.*

class ContactsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contacts = listOf(
            Contact(0, "ds0000000a", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null),
            Contact(0, "dsa", "dsa", "dsa", null, "dsa", "dsada", null)
        )
        val contactsAdapter = ContactsAdapter(contacts)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recycler.adapter = contactsAdapter
    }
}