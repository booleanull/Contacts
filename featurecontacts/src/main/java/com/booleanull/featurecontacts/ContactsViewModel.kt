package com.booleanull.featurecontacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booleanull.core.data.Address
import com.booleanull.core.data.Company
import com.booleanull.core.data.Contact
import com.booleanull.corerepository.ContactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ContactsViewModel @Inject constructor(val contactRepository: ContactRepository) : ViewModel() {

    private val contactsList = MutableLiveData<List<Contact>>()

    init {
        GlobalScope.launch(Dispatchers.Main) {
            contactsList.value = withContext(Dispatchers.IO) {
                contactRepository.getContacts().await()
            }
        }
    }

    fun getContacts(): LiveData<List<Contact>> = contactsList

    fun setContactList(list: List<Contact>) {
        contactsList.value = list
    }
}