package com.booleanull.coredatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.booleanull.core.data.ContactEntity

@Database(entities = [ContactEntity::class], version = 1, exportSchema = false)
abstract class ContactDatabase(): RoomDatabase() {
    abstract fun contactDao(): ContactDao
}