package com.booleanull.featureperson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.booleanull.core.data.ContactEntity
import com.booleanull.core.di.AppInjectHelper
import com.booleanull.featureperson.di.DaggerPersonComponent
import kotlinx.android.synthetic.main.fragment_person.*
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class PersonFragment : Fragment() {

    @Inject
    lateinit var cicerone: Cicerone<Router>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerPersonComponent
            .builder()
            .appComponent(AppInjectHelper.provideAppComponent(context!!.applicationContext))
            .build()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contact = arguments?.get("item") as ContactEntity
        toolbar.title = contact.name

        toolbar.navigationIcon =
            ContextCompat.getDrawable(context!!, R.drawable.ic_arrow_back_black_24dp)
        toolbar.setNavigationOnClickListener {
            cicerone.router.exit()
        }

        val prefFragment = PrefFragment()
        prefFragment.arguments = arguments

        childFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment, prefFragment)
            .commitNow()
    }

    class PrefFragment : PreferenceFragmentCompat() {

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
            val contact = arguments?.get("item") as ContactEntity

            val email = findPreference<Preference>("email")
            email?.title = contact.email?.toUpperCase()

            val username = findPreference<Preference>("username")
            username?.title = contact.username?.toUpperCase()

            val phone = findPreference<Preference>("phone")
            phone?.title = contact.phone?.toUpperCase()

            val website = findPreference<Preference>("website")
            website?.title = contact.website?.toUpperCase()

            val address = findPreference<Preference>("address")
            address?.title =
                "${contact.suite}, ${contact.street}, ${contact.city}, ${contact.zipcode}"

            val company = findPreference<Preference>("company")
            company?.title =
                "${contact.nameCompany?.toUpperCase()}\n${contact.catchPhrase?.toUpperCase()}\n${contact.bs?.toUpperCase()}"
        }
    }
}