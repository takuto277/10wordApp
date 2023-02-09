package com.example.a10wordapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.a10wordapp.data.db.entity.InitialQuizEntity

/**
 * Database access object to access the Inventory database
 */
@Dao
interface InitialQuizDao {
    @Query("SELECT * FROM InitialQuizEntity")
    suspend fun getAll(): List<InitialQuizEntity>

    @Insert
    suspend fun insert(InitialQuizEntity: InitialQuizEntity)

    @Query("delete from InitialQuizEntity")
    suspend fun deleteAll()

    @Update
    suspend fun update(InitialQuizEntity: InitialQuizEntity)
}