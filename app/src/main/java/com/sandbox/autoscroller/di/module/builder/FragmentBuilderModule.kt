package com.sandbox.autoscroller.di.module.builder

import com.sandbox.autoscroller.view.detail.DetailFragment
import com.sandbox.autoscroller.view.feed.FeedFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeFeedFragment(): FeedFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailFragment(): DetailFragment
}