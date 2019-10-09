package com.booleanull.featureperson.di

import com.booleanull.core.di.AppComponent
import com.booleanull.featureperson.PersonFragment
import dagger.Component

@PersonScope

@Component(dependencies = [AppComponent::class])
interface PersonComponent {

    fun inject(personFragment: PersonFragment)
}