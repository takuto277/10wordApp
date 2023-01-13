package com.example.a10wordapp.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 * Database access object to access the Inventory database
 */
@Dao
interface ItemDao {

    @Query("SELECT * FROM ItemEntiry")
    suspend fun getAll(): List<ItemEntiry>

    @Insert
    suspend fun insert(itemEntiry: ItemEntiry)

    @Delete
    suspend fun delete(itemEntiry: ItemEntiry)

}