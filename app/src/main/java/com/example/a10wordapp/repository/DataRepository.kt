package com.example.a10wordapp.repository

import android.content.Context
import com.example.a10wordapp.api.Data
import com.example.a10wordapp.data.ItemEntity
import com.example.a10wordapp.data.AppRoomDatabase
import kotlinx.coroutines.runBlocking

class DataRepository(private val context: Context) {
    fun addNewItem(id: Int, english: String, japanese: String) {
        val getDatabase = AppRoomDatabase.getDatabase(context)
        val itemEntiry = ItemEntity(id, english, japanese)
        val itemDao = getDatabase.itemDao()
        runBlocking {
            itemDao.insert(itemEntiry)
        }

        var list: List<ItemEntity>
        runBlocking {
            list = itemDao.getAll()
        }
    }

    fun saveInitialData(data: Array<Data>) {
    data.forEach {

    }
    }

    fun getList(): List<ItemEntity> {
        val getDatabase = AppRoomDatabase.getDatabase(context)
        val itemDao = getDatabase.itemDao()

        var list: List<ItemEntity>
        runBlocking {
            list = itemDao.getAll()
        }
        return list
    }
}