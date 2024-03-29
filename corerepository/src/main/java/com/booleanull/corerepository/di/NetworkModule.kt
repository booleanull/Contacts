package com.booleanull.corerepository.di

import com.booleanull.corenetwork.ApiService
import com.booleanull.corerepository.Constants.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @RepositoryScope
    @Provides
    fun getGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    @RepositoryScope
    @Provides
    fun getGsonConvertFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().setLenient().create())
    }

    @RepositoryScope
    @Provides
    fun getCoroutineCallAdapterFactory(): CoroutineCallAdapterFactory {
        return CoroutineCallAdapterFactory()
    }

    @RepositoryScope
    @Provides
    fun getRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        coroutineCallAdapterFactory: CoroutineCallAdapterFactory
    ): ApiService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(coroutineCallAdapterFactory)
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ApiService::class.java)
    }
}