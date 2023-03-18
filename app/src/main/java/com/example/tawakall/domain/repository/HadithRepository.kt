package com.example.tawakall.domain.repository

import com.example.tawakall.data.remote.dto.Hadith


interface HadithRepository {
    suspend fun getHadiths(): List<Hadith>
}
