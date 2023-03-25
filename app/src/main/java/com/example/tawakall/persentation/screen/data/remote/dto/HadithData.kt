package com.example.tawakall.persentation.screen.data.remote.dto

data class HadithData(
    val name: String? = null,
    val id: String? = null,
    val available:Long? = null,
    val requested:Int? = null,
    val hadiths: List<Hadith>,
)




