package com.example.tawakall.persentation.screen.data.repository

import com.example.tawakall.persentation.screen.data.remote.HadithApi
import com.example.tawakall.persentation.screen.data.remote.dto.Hadith
import com.example.tawakall.domain.repository.HadithRepository
import com.example.tawakall.persentation.screen.data.remote.dto.HadithData
import javax.inject.Inject

class HadithRepositroyImpl @Inject constructor(
    private val api: HadithApi
) : HadithRepository {
    override suspend fun getHadiths(): List<Hadith> {
        val response = api.getHadith()
        val returnData = response.data.hadiths
        return returnData
    }

    override suspend fun getDataHadist(): HadithData {
        val response = api.getHadith()
        return response.data
    }

    override suspend fun getHadistById(id: String, range: String): HadithData {
        val response = api.getHaditByName(id, range)
        return response.data
    }
}