package com.example.tawakall.data.remote


import com.example.tawakall.data.remote.dto.HadistResponse
import retrofit2.http.GET

interface HadithApi {
    @GET("/books/abu-daud?range=1-200")
    suspend fun getHadith(): HadistResponse



}