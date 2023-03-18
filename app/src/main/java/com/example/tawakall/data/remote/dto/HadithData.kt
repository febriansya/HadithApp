package com.example.tawakall.data.remote.dto

data class HadithData(
    val name: String? = null,
    val id: String? = null,
    val hadiths: List<Hadith>,
    val riwayah: String
)
