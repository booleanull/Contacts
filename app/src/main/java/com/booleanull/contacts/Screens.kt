package com.booleanull.contacts

import androidx.fragment.app.Fragment
import com.booleanull.featurecontacts.ContactsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screens {

    class ContactsScreen : SupportAppScreen() {

        override fun getFragment(): Fragment {
            return ContactsFragment()
        }
    }
}