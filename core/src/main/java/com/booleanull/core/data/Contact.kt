package com.booleanull.core.data

data class Contact(
    val id: Int,
    val name: String?,
    val username: String?,
    val email: String?,
    val address: Address?,
    val phone: String?,
    val website: String?,
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
    val street: String?,
    val suite: String?,
    val city: String?,
    val zipcode: String?,
    val geo: Geo
)

data class Geo(
    val lat: Double?,
    val lng: Double?
)

data class Company(
    val name: String?,
    val catchPhrase: String?,
    val bs: String?
)