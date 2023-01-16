package com.example.a10wordapp.Repository

import android.content.Context
import com.example.a10wordapp.Data.ItemEntiry
import com.example.a10wordapp.Data.ItemRoomDatabase
import kotlinx.coroutines.runBlocking

class RoomRepository() {
    fun addNewItem(context: Context, id:Int, english:String, japanese:String) {
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