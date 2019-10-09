package com.booleanull.featurecontacts.di

import androidx.lifecycle.ViewModel
import com.booleanull.core.di.ViewModelKey
import com.booleanull.featurecontacts.ContactsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ContactsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ContactsViewModel::class)
    abstract fun webViewModel(viewModel: ContactsViewModel): ViewModel
}
