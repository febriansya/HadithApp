package com.example.tawakall.persentation.screen.data.remote


import com.example.tawakall.persentation.screen.data.remote.dto.HadistResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HadithApi {
    @GET("/books/abu-daud?range=1-300")
    suspend fun getHadith(): HadistResponse

    @GET("/books/{id}")
    suspend fun getHaditByName(
        @Path("id") id: String,
        @Query("range") range: String
    ): HadistResponse
}
