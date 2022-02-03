package com.vkydroid.cleanarch.data

import com.vkydroid.cleanarch.domain.People
import com.vkydroid.cleanarch.domain.RemoteDataSource
import com.vkydroid.cleanarch.domain.common.Resource
import com.vkydroid.cleanarch.domain.reppository.PeopleRepository
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : PeopleRepository {
    override suspend fun getPeople(): Resource<List<People>> {
        return remoteDataSource.getPeople()
    }
}