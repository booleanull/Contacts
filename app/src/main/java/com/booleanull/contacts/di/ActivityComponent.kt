package com.booleanull.contacts.di

import com.booleanull.contacts.MainActivity
import com.booleanull.core.di.AppComponent
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}