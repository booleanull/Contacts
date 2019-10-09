package com.booleanull.featurecontacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booleanull.core.data.Contact
import javax.inject.Inject

class ContactsViewModel @Inject constructor() : ViewModel() {

    private val contactsList = MutableLiveData<List<Contact>>()

    init {
        setContactList(
            listOf(
                Contact(0, "ds0000000a", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(1, "1dsa", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(2, "2dsa", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(3, "3dsa", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(4, "4dsa", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(5, "5dsa", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(6, "6dsa", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(7, "7dsa", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(9, "8dsa", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(8, "9dsa", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(10, "10dsa", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(11, "11dsa", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(12, "12dsa", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(13, "13dsa", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(14, "14dsa", "dsa", "dsa", null, "dsa", "dsada", null),
                Contact(15, "15dsa", "dsa", "dsa", null, "dsa", "dsada", null)
            )
        )
    }

    fun getContacts(): LiveData<List<Contact>> = contactsList

    fun setContactList(list: List<Contact>) {
        contactsList.value = list
    }
}