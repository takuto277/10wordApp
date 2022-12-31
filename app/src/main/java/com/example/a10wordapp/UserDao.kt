package com.example.a10wordapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("DELETE FROM user_table")
    suspend fun clear()

    @Query("SELECT * FROM user_table WHERE id = :key")
    suspend fun get(key: Long): User?
}