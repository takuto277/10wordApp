package com.example.a10wordapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.a10wordapp.data.db.entity.UserEditQuizEntity

/**
 * Database access object to access the Inventory database
 */
@Dao
interface UserEditQuizDao {
    @Query("SELECT * FROM UserEditQuizEntity")
    suspend fun getAll(): List<UserEditQuizEntity>

    @Insert
    suspend fun insert(itemEntiry: UserEditQuizEntity)

    @Delete
    suspend fun delete(itemEntiry: UserEditQuizEntity)
}