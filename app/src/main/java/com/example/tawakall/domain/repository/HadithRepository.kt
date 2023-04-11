package com.example.tawakall.domain.repository

import com.example.tawakall.data.source.remote.dto.Hadith
import com.example.tawakall.data.source.remote.dto.HadithData
import com.example.tawakall.domain.model.ReadHadith
import kotlinx.coroutines.flow.Flow


interface HadithRepository {
    suspend fun getHadiths(): List<Hadith>
    suspend fun getDataHadist(): HadithData
    suspend fun getHadistById(id: String, range: String): HadithData

     fun getLastRead():Flow<List<ReadHadith>>

    suspend fun insertLastRead(readHadith: ReadHadith)
}
