package com.example.tawakall.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tawakall.domain.model.ReadHadith
import kotlinx.coroutines.flow.Flow

@Dao
interface HadithDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(readHadith: ReadHadith)

    @Query("SELECT * FROM last")
    fun getAll(): Flow<List<ReadHadith>>
}
