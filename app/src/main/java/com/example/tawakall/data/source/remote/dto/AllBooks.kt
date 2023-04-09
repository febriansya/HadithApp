package com.example.tawakall.data.source.remote.dto

data class AllBooks(
    val code: Int,
    val data: List<Data>,
    val error: Boolean,
    val message: String
)