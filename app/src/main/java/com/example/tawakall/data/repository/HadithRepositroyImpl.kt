package com.example.tawakall.data.repository

import com.example.tawakall.data.remote.HadithApi
import com.example.tawakall.data.remote.dto.Hadith
import com.example.tawakall.domain.repository.HadithRepository
import javax.inject.Inject

class HadithRepositroyImpl @Inject constructor(
    private val api: HadithApi
) : HadithRepository {
    override suspend fun getHadiths(): List<Hadith> {
        val response = api.getHadith()
        return response.data.hadiths
    }
}