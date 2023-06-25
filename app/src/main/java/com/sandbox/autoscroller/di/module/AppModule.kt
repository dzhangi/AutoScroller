package com.sandbox.autoscroller.di.module

import com.sandbox.autoscroller.di.module.builder.ActivityBuilderModule
import com.sandbox.autoscroller.di.module.builder.FragmentBuilderModule
import com.sandbox.autoscroller.di.module.network.ApiModule
import com.sandbox.autoscroller.di.module.viewmodel.ViewModelModule
import dagger.Module

@Module(
    includes = [
        ActivityBuilderModule::class,
        FragmentBuilderModule::class,
        ViewModelModule::class,
        ApiModule::class,
    ]
)
class AppModule