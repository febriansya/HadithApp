package com.example.tawakall.domain.use_case

import com.example.tawakall.domain.model.InvalidHadithException
import com.example.tawakall.domain.model.ReadHadith
import com.example.tawakall.domain.repository.HadithRepository
import javax.inject.Inject

class InsertHadithUseCase(
    val repository: HadithRepository
) {
    @Throws(InvalidHadithException::class)
    suspend  operator fun invoke(readHadith: ReadHadith) {
        if (readHadith.number.isBlank()){
            throw InvalidHadithException("the number cant be null")
        }
//        else
        repository.insertLastRead(readHadith)
    }
}