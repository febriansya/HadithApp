package com.example.tawakall.domain.use_case

import android.database.DatabaseErrorHandler
import com.example.tawakall.common.Resource
import com.example.tawakall.domain.model.ReadHadith
import com.example.tawakall.domain.repository.HadithRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetLastHadithUseCase(
    val repository: HadithRepository
) {
    operator fun invoke():Flow<List<ReadHadith>>{
        return repository.getLastRead()
    }
}