package com.example.a10wordapp.ui.add

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.Data.ItemRoomDatabase
import com.example.a10wordapp.Data.ItemEntiry
import kotlinx.coroutines.runBlocking

class AddViewModel: ViewModel() {
    fun newItem(context: Context, id:Int, english:String, japanese:String){
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
        println("papa,${list}")
    }
}