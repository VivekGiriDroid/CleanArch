package com.vkydroid.cleanarch.domain

import com.vkydroid.cleanarch.domain.common.Resource

interface RemoteDataSource {
    suspend fun getPeople(): Resource<List<People>>
}