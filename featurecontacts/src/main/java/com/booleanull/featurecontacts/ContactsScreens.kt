package com.booleanull.featurecontacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.booleanull.core.data.Contact
import com.booleanull.core.data.convertToContactEntity
import com.booleanull.featureperson.PersonFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object ContactsScreens {

    class PersonScreen(private val contact: Contact) : SupportAppScreen() {

        override fun getFragment(): Fragment {
            val fragment = PersonFragment()
            val bundle = Bundle()
            bundle.putParcelable("item", contact.convertToContactEntity())
            fragment.arguments = bundle
            return fragment
        }
    }
}