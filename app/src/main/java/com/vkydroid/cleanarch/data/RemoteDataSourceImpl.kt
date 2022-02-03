package com.vkydroid.cleanarch.data

import com.vkydroid.cleanarch.data.api.PeopleApi
import com.vkydroid.cleanarch.data.mappers.PeopleApiResponseMapper
import com.vkydroid.cleanarch.domain.People
import com.vkydroid.cleanarch.domain.RemoteDataSource
import com.vkydroid.cleanarch.domain.common.Resource
import java.lang.Exception
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val retrofit: PeopleApi,
    private val mapper: PeopleApiResponseMapper
) : RemoteDataSource {
    override suspend fun getPeople(): Resource<List<People>> {
        return try {
            println(" Tread name : " + Thread.currentThread().name)
            val response = retrofit.getPeople()
            if (response != null) {
                Resource.Success(mapper.toPeopleList(response))
            } else {
                Resource.Error(Exception("error happened"))
            }
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}