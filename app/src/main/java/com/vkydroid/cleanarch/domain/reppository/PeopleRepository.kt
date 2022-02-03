package com.vkydroid.cleanarch.domain.reppository

import com.vkydroid.cleanarch.domain.People
import com.vkydroid.cleanarch.domain.common.Resource

interface PeopleRepository {
    suspend fun getPeople(): Resource<List<People>>
}