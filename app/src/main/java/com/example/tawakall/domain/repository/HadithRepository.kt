package com.example.tawakall.domain.repository

import com.example.tawakall.persentation.screen.data.remote.dto.Hadith
import com.example.tawakall.persentation.screen.data.remote.dto.HadithData


interface HadithRepository {
    suspend fun getHadiths(): List<Hadith>
    suspend fun getDataHadist(): HadithData
    suspend fun getHadistById(id:String,range:String): HadithData

}
