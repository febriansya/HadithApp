package com.example.tawakall.persentation.screen.home

import com.example.tawakall.persentation.screen.data.remote.dto.Hadith
import com.example.tawakall.persentation.screen.data.remote.dto.HadithData


data class HadithListState(
    val isLoading: Boolean = false,
    val hadith: List<Hadith> = emptyList(),
    val error: String = "",
    val riwayah: HadithData? = null

)