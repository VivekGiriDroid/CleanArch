package com.vkydroid.cleanarch.di

import com.vkydroid.cleanarch.App
import com.vkydroid.cleanarch.di.modules.ActivityModule
import com.vkydroid.cleanarch.di.modules.NetworkModule
import com.vkydroid.cleanarch.di.modules.RepoModule
import com.vkydroid.cleanarch.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        RepoModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }
}