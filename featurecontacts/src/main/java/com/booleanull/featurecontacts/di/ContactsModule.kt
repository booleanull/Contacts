package com.booleanull.featurecontacts.di

import com.booleanull.corerepository.ContactRepository
import dagger.Module
import dagger.Provides

@Module
class ContactsModule {

    @ContactsScope
    @Provides
    internal fun provideContactRepository() = ContactRepository()
}