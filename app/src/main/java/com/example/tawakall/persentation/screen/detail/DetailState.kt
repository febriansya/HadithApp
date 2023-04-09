package com.example.tawakall.persentation.screen.detail

import com.example.tawakall.domain.model.ReadHadith

data class DetailState(
    val isLoading:Boolean = false,
    val error:String ="",
    val readHadith: ReadHadith?=null,
)