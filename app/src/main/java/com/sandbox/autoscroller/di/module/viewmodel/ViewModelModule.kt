package com.sandbox.autoscroller.di.module.viewmodel

import com.sandbox.autoscroller.di.module.viewmodel.ViewModelFactoryModule
import dagger.Module

@Module(
    includes = [ViewModelFactoryModule::class]
)
abstract class ViewModelModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(MainActivityViewModel::class)
//    abstract fun bindMainViewModel(viewModel: MainActivityViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(SecondFragmentViewModel::class)
//    abstract fun bindSecondViewModel(viewModel: SecondFragmentViewModel): ViewModel
}