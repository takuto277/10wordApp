package com.example.a10wordapp.Repository

import android.content.Context
import com.example.a10wordapp.Data.ItemEntiry
import com.example.a10wordapp.Data.ItemRoomDatabase
import kotlinx.coroutines.runBlocking

class RoomRepository() {
    fun getList(context: Context): List<ItemEntiry>{
        val getDatabase = ItemRoomDatabase.getDatabase(context)
        val itemDao = getDatabase.itemDao()

        var list: List<ItemEntiry>
        runBlocking {
            list = itemDao.getAll()
        }
        return list
    }
}