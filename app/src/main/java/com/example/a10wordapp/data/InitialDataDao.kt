package com.example.a10wordapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.DeleteTable
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Database access object to access the Inventory database
 */
@Dao
interface InitialDataDao {

    @Query("SELECT * FROM InitialDataEntity")
    suspend fun getAll(): List<InitialDataEntity>

    @Insert
    suspend fun insert(InitialDataEntity: InitialDataEntity)

    @Query("delete from InitialDataEntity")
    suspend fun deleteAll()

    @Update
    suspend fun update(InitialDataEntity: InitialDataEntity)

}