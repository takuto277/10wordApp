package com.example.a10wordapp.repository

import android.content.Context
import com.example.a10wordapp.data.ItemEntiry
import com.example.a10wordapp.data.ItemRoomDatabase
import kotlinx.coroutines.runBlocking

class DataRepository(private val context: Context) {
    fun addNewItem(id: Int, english: String, japanese: String) {
        val getDatabase = ItemRoomDatabase.getDatabase(context)
        val itemEntiry = ItemEntiry(id, english, japanese)
        val itemDao = getDatabase.itemDao()
        runBlocking {
            itemDao.insert(itemEntiry)
        }

        var list: List<ItemEntiry>
        runBlocking {
            list = itemDao.getAll()
        }
    }

    fun getList(): List<ItemEntiry> {
        val getDatabase = ItemRoomDatabase.getDatabase(context)
        val itemDao = getDatabase.itemDao()

        var list: List<ItemEntiry>
        runBlocking {
            list = itemDao.getAll()
        }
        return list
    }
}