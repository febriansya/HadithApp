package com.example.tawakall.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "last")
data class ReadHadith(
    @PrimaryKey
    val id:String,
    val number:String,
)

class InvalidHadithException(message:String):Exception(message)