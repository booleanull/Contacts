package com.booleanull.featurecontacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booleanull.core.base.MyViewModel
import com.booleanull.core.data.Contact
import com.booleanull.corerepository.ContactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ContactsViewModel @Inject constructor(private val contactRepository: ContactRepository) :
    MyViewModel() {

    private val contactsList = MutableLiveData<List<Contact>>()

    private val loading = MutableLiveData<Boolean>()

    private val error = MutableLiveData<Boolean>()

    init {
        error.value = false
        uiScope.launch(Dispatchers.Main) {
            loading.value = true
            try {
                contactsList.value = withContext(Dispatchers.IO) {
                    contactRepository.getContactsNetwork().await()
                }
                withContext(Dispatchers.IO) {
                    contactRepository.insertContracts(contactsList.value!!)
                }
            } catch (e: Exception) {
                contactsList.value = withContext(Dispatchers.IO) {
                    contactRepository.getContractsDatabase()
                }
                error.value = true
            }
            loading.value = false
        }
    }

    fun getContacts(): LiveData<List<Contact>> = contactsList

    fun setContactList(list: List<Contact>) {
        contactsList.value = list
    }

    fun getLoading(): LiveData<Boolean> = loading

    fun getError(): LiveData<Boolean> = error

    fun setError(status: Boolean) {
        error.value = status
    }
}