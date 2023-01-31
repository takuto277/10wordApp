package com.example.a10wordapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * Database access object to access the Inventory database
 */
@Dao
interface ItemDao {
    @Query("SELECT * FROM ItemEntity")
    suspend fun getAll(): List<ItemEntity>

    @Insert
    suspend fun insert(itemEntiry: ItemEntity)

    @Delete
    suspend fun delete(itemEntiry: ItemEntity)
}