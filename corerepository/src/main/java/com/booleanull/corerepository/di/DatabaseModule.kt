package com.booleanull.corerepository.di

import android.content.Context
import androidx.room.Room
import com.booleanull.coredatabase.ContactDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @RepositoryScope
    fun getDatabase(context: Context): ContactDatabase {
        return Room.databaseBuilder(context, ContactDatabase::class.java, "ContactDatabase")
            .build()
    }
}