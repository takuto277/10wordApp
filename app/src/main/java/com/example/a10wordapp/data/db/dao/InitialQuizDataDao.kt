package com.example.a10wordapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.a10wordapp.data.db.entity.InitialQuizDataEntity

/**
 * Database access object to access the Inventory database
 */
@Dao
interface InitialQuizDataDao {
    @Query("SELECT * FROM InitialQuizDataEntity")
    suspend fun getAll(): List<InitialQuizDataEntity>

    @Insert
    suspend fun insert(InitialQuizDataEntity: InitialQuizDataEntity)

    @Query("delete from InitialQuizDataEntity")
    suspend fun deleteAll()

    @Update
    suspend fun update(InitialQuizDataEntity: InitialQuizDataEntity)
}