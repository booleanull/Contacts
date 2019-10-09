package com.booleanull.corenetwork

import com.booleanull.core.data.Contact
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    fun getContactsAsync(): Deferred<List<Contact>>
}