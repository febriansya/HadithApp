package com.example.tawakall.data.source.remote.dto

data class HadithData(
    val name: String? = null,
    val id: String? = null,
    val available:Long? = null,
    val requested:Int? = null,
    val hadiths: List<Hadith>,
)




