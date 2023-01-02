package com.example.a10wordapp.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Database access object to access the Inventory database
 */
@Dao
interface ItemDao {

    @Query("SELECT * FROM item_table")
    fun loadLiveData(): LiveData<List<Item>>

    @Insert
    suspend fun insert(item: Item)

    @Delete
    suspend fun delete(item: Item)

}