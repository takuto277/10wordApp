package com.example.a10wordapp.ui.list

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.Data.ItemEntiry
import com.example.a10wordapp.Data.ItemRoomDatabase
import kotlinx.coroutines.runBlocking

open class ListViewModel: ViewModel() {
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