package com.vkydroid.cleanarch.domain.common

import java.lang.Exception

sealed class Resource<out R> {

    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val exception: Exception) : Resource<Nothing>()
}

