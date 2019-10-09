package com.booleanull.core.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactEntity(
    @PrimaryKey
    val id: Int,
    val name: String?,
    val username: String?,
    val email: String?,
    val street: String?,
    val suite: String?,
    val city: String?,
    val zipcode: String?,
    val lat: Double?,
    val lng: Double?,
    val phone: String?,
    val website: String?,
    val nameCompany: String?,
    val catchPhrase: String?,
    val bs: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(username)
        parcel.writeString(email)
        parcel.writeString(street)
        parcel.writeString(suite)
        parcel.writeString(city)
        parcel.writeString(zipcode)
        parcel.writeValue(lat)
        parcel.writeValue(lng)
        parcel.writeString(phone)
        parcel.writeString(website)
        parcel.writeString(nameCompany)
        parcel.writeString(catchPhrase)
        parcel.writeString(bs)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContactEntity> {
        override fun createFromParcel(parcel: Parcel): ContactEntity {
            return ContactEntity(parcel)
        }

        override fun newArray(size: Int): Array<ContactEntity?> {
            return arrayOfNulls(size)
        }
    }
}

fun ContactEntity.convertToContact() = Contact(
    this.id,
    this.name,
    this.username,
    this.email,
    Address(this.street, this.suite, this.city, this.zipcode, Geo(this.lat, this.lng)),
    this.phone,
    this.website,
    Company(this.nameCompany, this.catchPhrase, this.bs)
)