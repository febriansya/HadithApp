package com.example.tawakall.persentation.screen.home

import com.example.tawakall.data.source.remote.dto.Hadith
import com.example.tawakall.data.source.remote.dto.HadithData
import com.example.tawakall.domain.model.ReadHadith


data class HadithListState(
    val isLoading: Boolean = false,
    val hadith: List<Hadith> = emptyList(),
    val error: String = "",
    val riwayah: HadithData? = null,
    val lastRead:List<ReadHadith> = emptyList()
)