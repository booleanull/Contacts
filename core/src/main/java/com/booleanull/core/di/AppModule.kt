package com.booleanull.core.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    internal fun provideContext() = context

    @Singleton
    @Provides
    internal fun provideCicerone() = Cicerone.create()
}