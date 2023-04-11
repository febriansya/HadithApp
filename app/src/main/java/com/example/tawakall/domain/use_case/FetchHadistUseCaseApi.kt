package com.example.tawakall.domain.use_case

import com.example.tawakall.common.Resource
import com.example.tawakall.data.source.remote.dto.HadithData
import com.example.tawakall.domain.repository.HadithRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FetchHadistUseCaseApi(
    private val repository: HadithRepository,
) {
    operator fun invoke(id: String, range: String): Flow<Resource<HadithData>> = flow {
        try {
            emit(Resource.Loading<HadithData>())
            val hadithData = repository.getHadistById(id, range)
            emit(Resource.Success<HadithData>(hadithData))
        } catch (e: HttpException) {
            emit(
                Resource.Error<HadithData>(
                    e.localizedMessage ?: ("An unexpected error occured")
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<HadithData>(e.message))
        }
    }
}