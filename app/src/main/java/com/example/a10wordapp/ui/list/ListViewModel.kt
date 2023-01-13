package com.example.a10wordapp.ui.list

import android.content.Context
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.Data.Item
import com.example.a10wordapp.Data.ItemRoomDatabase
import kotlinx.coroutines.runBlocking

open class ListViewModel: ViewModel() {
    fun getList(context: Context): List<Item>{
        val getDatabase = ItemRoomDatabase.getDatabase(context)
        val itemDao = getDatabase.itemDao()

        var list: List<Item>
        runBlocking {
            list = itemDao.getAll()
        }
        return list
    }
}