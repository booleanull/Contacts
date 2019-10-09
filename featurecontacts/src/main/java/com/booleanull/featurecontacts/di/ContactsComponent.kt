package com.booleanull.featurecontacts.di

import com.booleanull.core.di.AppComponent
import com.booleanull.featurecontacts.ContactsFragment
import dagger.Component

@ContactsScope
@Component(dependencies = [AppComponent::class], modules = [ContactsViewModelModule::class, ContactsModule::class])
interface ContactsComponent {

    fun inject(contactsFragment: ContactsFragment)
}