package com.example.a10wordapp.ui.add

import android.content.Context
import com.example.a10wordapp.ui.base.BaseViewModel
import com.example.a10wordapp.ui.add.AddActivity
import com.example.a10wordapp.Data.ItemRoomDatabase
import com.example.a10wordapp.Data.Item
import kotlinx.coroutines.runBlocking

class AddViewModel: BaseViewModel() {
    fun NewItem(context: Context, id:Int, english:String, japanese:String){
        val getDatabase = ItemRoomDatabase.getDatabase(context)
        val item = Item(id, english, japanese)
        val itemDao = getDatabase.itemDao()
        runBlocking {
            itemDao.insert(item)
        }

        var list: List<Item>
        runBlocking {
            list = itemDao.getAll()
        }
        println("papa,${list}")
    }
}