package com.example.tawakall.data.source.repository

import com.example.tawakall.data.source.local.dao.HadithDao
import com.example.tawakall.data.source.remote.HadithApi
import com.example.tawakall.data.source.remote.dto.Hadith
import com.example.tawakall.data.source.remote.dto.HadithData
import com.example.tawakall.domain.model.ReadHadith
import com.example.tawakall.domain.repository.HadithRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HadithRepositroyImpl @Inject constructor(
    private val api: HadithApi,
    private val dao: HadithDao
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

    override  fun getLastRead():Flow<List<ReadHadith>> {
        return dao.getAll()
    }

    override suspend fun insertLastRead(readHadith: ReadHadith) {
        return dao.insert(readHadith)
    }
}