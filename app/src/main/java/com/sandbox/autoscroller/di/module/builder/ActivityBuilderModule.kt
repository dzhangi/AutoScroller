package com.sandbox.autoscroller.di.module.builder

import com.sandbox.autoscroller.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity
}