package com.vkydroid.cleanarch.data.mappers

import com.vkydroid.cleanarch.data.api.PeopleApiResponse
import com.vkydroid.cleanarch.domain.People
import javax.inject.Inject


class PeopleApiResponseMapper @Inject constructor() {
    fun toPeopleList(response: PeopleApiResponse): List<People>{
        return response.results.map {
            People(
                name = it.name,
                height = it.height,
            )
        }
    }
}