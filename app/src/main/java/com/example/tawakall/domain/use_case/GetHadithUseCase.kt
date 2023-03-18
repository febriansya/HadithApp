package com.example.tawakall.domain.use_case

import com.example.tawakall.common.Resource
import com.example.tawakall.domain.model.Hadith
import com.example.tawakall.domain.repository.HadithRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetHadithUseCase @Inject constructor(
    private val repository: HadithRepository
) {
    operator fun invoke(): Flow<Resource<List<Hadith>>> = flow {
        try {
            emit(Resource.Loading<List<Hadith>>())
            val hadith = repository.getHadiths()
            emit(Resource.Success<List<Hadith>>(hadith))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Hadith>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Hadith>>("Couldn't reach server. Check your internet connection."))
        }
    }
}