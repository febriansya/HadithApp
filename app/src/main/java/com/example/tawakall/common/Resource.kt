package com.example.tawakall.common

import com.example.tawakall.data.remote.dto.Hadith

sealed class Resource<T>(val data: Any? = null, val message: String? = null) {
    class Success<T>(data: List<Hadith>) : Resource<T>(data)
    class Error<T : Any>(message: String?, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}