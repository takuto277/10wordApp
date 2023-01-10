package com.example.a10wordapp.ui.add

import android.content.Context
import com.example.a10wordapp.ui.base.BaseViewModel
import com.example.a10wordapp.ui.add.AddActivity
import com.example.a10wordapp.Data.ItemRoomDatabase
import com.example.a10wordapp.Data.Item
import kotlinx.coroutines.runBlocking

class AddViewModel: BaseViewModel() {
    fun NewItem(context: Context, id:Int, english:String, japanese:String){
        val hoge = ItemRoomDatabase.getDatabase(context)
        val item = Item(id, english, japanese)
        val huga = hoge.itemDao()
        runBlocking {
            huga.insert(item)
        }

        var list: List<Item>
        runBlocking {
            list = huga.getAll()
        }
        println("papa,${list}")
    }
}