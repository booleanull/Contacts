package com.booleanull.corerepository.di

import com.booleanull.corerepository.ContactRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    fun inject(contactRepository: ContactRepository)
}