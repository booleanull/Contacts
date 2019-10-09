package com.booleanull.corerepository

import android.content.Context
import com.booleanull.core.data.Contact
import com.booleanull.core.data.convertToContact
import com.booleanull.core.data.convertToContactEntity
import com.booleanull.core.di.AppInjectHelper
import com.booleanull.coredatabase.ContactDatabase
import com.booleanull.corenetwork.ApiService
import com.booleanull.corerepository.di.DaggerRepositoryComponent
import com.booleanull.corerepository.di.DatabaseModule
import com.booleanull.corerepository.di.NetworkModule
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class ContactRepository(private val context: Context) {

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var database: ContactDatabase

    init {
        DaggerRepositoryComponent
            .builder()
            .appComponent(AppInjectHelper.provideAppComponent(context.applicationContext))
            .networkModule(NetworkModule())
            .databaseModule(DatabaseModule())
            .build()
            .inject(this)
    }

    fun getContactsNetwork(): Deferred<List<Contact>> {
        return apiService.getContactsAsync()
    }

    suspend fun getContractsDatabase(): List<Contact> {
        return database.contactDao().all().map { it.convertToContact() }
    }

    suspend fun insertContracts(list: List<Contact>) {
        database.contactDao().insert(list.map { it.convertToContactEntity() })
    }
}