package com.vkydroid.cleanarch.di.modules

import com.vkydroid.cleanarch.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}