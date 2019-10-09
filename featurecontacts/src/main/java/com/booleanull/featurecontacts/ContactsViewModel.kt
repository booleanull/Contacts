package com.booleanull.featurecontacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booleanull.core.data.Contact
import javax.inject.Inject

class ContactsViewModel @Inject constructor() : ViewModel() {

    private val contactsList = MutableLiveData<List<Contact>>()

    fun getContacts(): LiveData<List<Contact>> = contactsList

    fun setContactList(list: List<Contact>) {
        contactsList.value = list
    }
}