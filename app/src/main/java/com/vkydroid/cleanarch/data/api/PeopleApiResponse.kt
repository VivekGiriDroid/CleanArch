package com.vkydroid.cleanarch.data.api

import com.google.gson.annotations.SerializedName

data class PeopleApiResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("results")
    val results: List<PeopleResponse>
)

data class PeopleResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("mass")
    val mass: String,
    @SerializedName("hair_color")
    val hairColor: String
)