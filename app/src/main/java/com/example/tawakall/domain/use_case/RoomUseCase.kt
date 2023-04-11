package com.example.tawakall.domain.use_case

import javax.inject.Inject

data class RoomUseCase @Inject constructor (
    val insertHadithUseCase: InsertHadithUseCase,
    val getLastHadithUseCase: GetLastHadithUseCase,
    val fetchHadistUseCaseApi: FetchHadistUseCaseApi
)
