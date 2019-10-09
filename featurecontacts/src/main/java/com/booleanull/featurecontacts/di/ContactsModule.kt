package com.booleanull.featurecontacts.di

import android.content.Context
import com.booleanull.corerepository.ContactRepository
import dagger.Module
import dagger.Provides

@Module
class ContactsModule {

    @ContactsScope
    @Provides
    internal fun provideContactRepository(context: Context) = ContactRepository(context)
}