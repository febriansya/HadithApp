package com.example.tawakall.domain.repository

import com.example.tawakall.data.source.remote.dto.Hadith
import com.example.tawakall.data.source.remote.dto.HadithData
import com.example.tawakall.domain.model.ReadHadith


interface HadithRepository {
    suspend fun getHadiths(): List<Hadith>
    suspend fun getDataHadist(): HadithData
    suspend fun getHadistById(id: String, range: String): HadithData

    suspend fun getLastRead(): List<ReadHadith>

    suspend fun insertLastRead(readHadith: ReadHadith)
}
