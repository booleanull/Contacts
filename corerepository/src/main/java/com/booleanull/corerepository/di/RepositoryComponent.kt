package com.booleanull.corerepository.di

import com.booleanull.core.di.AppComponent
import com.booleanull.corerepository.ContactRepository
import dagger.Component
import javax.inject.Singleton

@RepositoryScope
@Component(dependencies = [AppComponent::class], modules = [NetworkModule::class, DatabaseModule::class])
interface RepositoryComponent {

    fun inject(contactRepository: ContactRepository)
}