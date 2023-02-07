package com.example.a10wordapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.a10wordapp.data.db.entity.UserEditQuizDataEntity

/**
 * Database access object to access the Inventory database
 */
@Dao
interface UserEditQuizDataDao {
    @Query("SELECT * FROM UserEditQuizDataEntity")
    suspend fun getAll(): List<UserEditQuizDataEntity>

    @Insert
    suspend fun insert(itemEntiry: UserEditQuizDataEntity)

    @Delete
    suspend fun delete(itemEntiry: UserEditQuizDataEntity)
}