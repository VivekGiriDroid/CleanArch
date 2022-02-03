package com.vkydroid.cleanarch.di.modules

import com.vkydroid.cleanarch.data.PeopleRepositoryImpl
import com.vkydroid.cleanarch.data.RemoteDataSourceImpl
import com.vkydroid.cleanarch.domain.RemoteDataSource
import com.vkydroid.cleanarch.domain.reppository.PeopleRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepoModule {

    @Binds
    abstract fun providePeopleRepo(peopleRepositoryImpl: PeopleRepositoryImpl): PeopleRepository

    @Binds
    abstract fun provideRemoteSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}