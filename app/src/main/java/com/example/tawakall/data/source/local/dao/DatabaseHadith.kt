package com.example.tawakall.data.source.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tawakall.domain.model.ReadHadith

@Database(entities = [ReadHadith::class], version = 1)
abstract class DatabaseHadith : RoomDatabase() {
    abstract fun hadithDao(): HadithDao
}