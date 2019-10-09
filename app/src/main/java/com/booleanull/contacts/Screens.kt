package com.booleanull.contacts

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screens {

    class ContactsScreen : SupportAppScreen() {

        override fun getFragment(): Fragment {
            return ContactsFragment()
        }
    }

    class PersonScreen : SupportAppScreen() {

        override fun getFragment(): Fragment {
            return PersonFragment()
        }
    }
}