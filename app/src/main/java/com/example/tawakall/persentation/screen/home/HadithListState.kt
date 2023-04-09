package com.example.tawakall.persentation.screen.home

import com.example.tawakall.data.source.remote.dto.Hadith
import com.example.tawakall.data.source.remote.dto.HadithData


data class HadithListState(
    val isLoading: Boolean = false,
    val hadith: List<Hadith> = emptyList(),
    val error: String = "",
    val riwayah: HadithData? = null
)