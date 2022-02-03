package com.vkydroid.cleanarch.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vkydroid.cleanarch.di.ViewModelFactory
import com.vkydroid.cleanarch.di.annotations.ViewModelKey
import com.vkydroid.cleanarch.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModel(vm: MainViewModel): ViewModel
}