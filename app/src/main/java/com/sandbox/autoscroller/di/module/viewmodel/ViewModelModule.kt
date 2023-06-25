package com.sandbox.autoscroller.di.module.viewmodel

import androidx.lifecycle.ViewModel
import com.sandbox.autoscroller.viewmodel.MainViewModel
import com.sandbox.autoscroller.viewmodel.detail.DetailViewModel
import com.sandbox.autoscroller.viewmodel.feed.FeedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [ViewModelFactoryModule::class]
)
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FeedViewModel::class)
    abstract fun bindFeedViewModel(viewModel: FeedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(viewModel: FeedViewModel): ViewModel
}