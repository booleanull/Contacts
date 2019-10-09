package com.booleanull.corerepository

import com.booleanull.core.data.Contact
import com.booleanull.corenetwork.ApiService
import com.booleanull.corerepository.di.DaggerNetworkComponent
import com.booleanull.corerepository.di.NetworkModule
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class ContactRepository {

    @Inject
    lateinit var apiService: ApiService

    init {
        DaggerNetworkComponent
            .builder()
            .networkModule(NetworkModule())
            .build()
            .inject(this)
    }

    fun getContacts(): Deferred<List<Contact>> {
        return apiService.getContactsAsync()
    }
}