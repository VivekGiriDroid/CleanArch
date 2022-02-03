package com.vkydroid.cleanarch.data.api

import retrofit2.http.GET

const val PEOPLE = "people"

interface PeopleApi {
    @GET(PEOPLE)
    suspend fun getPeople(): PeopleApiResponse?
}