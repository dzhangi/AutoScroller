package com.sandbox.autoscroller.di.module.network

import com.sandbox.autoscroller.model.api.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ApiModule {

    @Singleton
    @Provides
    fun provideAutoApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}