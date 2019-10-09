package com.booleanull.core.data

import com.google.gson.annotations.Expose

data class Contact(
    @Expose
    val id: Int,
    @Expose
    val name: String?,
    @Expose
    val username: String?,
    @Expose
    val email: String?,
    @Expose
    val address: Address?,
    @Expose
    val phone: String?,
    @Expose
    val website: String?,
    @Expose
    val company: Company?
)

fun Contact.convertToContactEntity() = ContactEntity(
    this.id,
    this.name,
    this.username,
    this.email,
    this.address?.street,
    this.address?.suite,
    this.address?.city,
    this.address?.zipcode,
    this.address?.geo?.lat,
    this.address?.geo?.lng,
    this.phone,
    this.website,
    this.company?.name,
    this.company?.catchPhrase,
    this.company?.bs
)

data class Address(
    @Expose
    val street: String?,
    @Expose
    val suite: String?,
    @Expose
    val city: String?,
    @Expose
    val zipcode: String?,
    @Expose
    val geo: Geo?
)

data class Geo(
    @Expose
    val lat: Double?,
    @Expose
    val lng: Double?
)

data class Company(
    @Expose
    val name: String?,
    @Expose
    val catchPhrase: String?,
    @Expose
    val bs: String?
)