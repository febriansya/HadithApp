package com.example.tawakall.persentation.screen.home

import com.example.tawakall.data.remote.dto.Hadith


data class HadithListState(
    val isLoading: Boolean = false,
    val hadith: List<Hadith> = emptyList(),
    val error: String = "",
    val riwayah: String = ""

)