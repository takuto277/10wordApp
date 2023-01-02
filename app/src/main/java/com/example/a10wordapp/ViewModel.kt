//package com.example.a10wordapp
//
//import androidx.lifecycle.LiveData
//import com.example.a10wordapp.Data.ItemDao
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.a10wordapp.Data.Item
//import com.example.a10wordapp.Data.ItemRoomDatabase
//import kotlinx.coroutines.Dispatchers
//import android.app.Application
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.launch
//
//class ViewModel(application: Application): ViewModel() {
//
//    private val itemDao: ItemDao
//    init {
//        val db = ItemRoomDatabase.getDatabase(application)
//        itemDao = db.itemDao()
//    }
//
//    val wordLiveData = itemDao.loadLiveData()
//
//    fun addNewItem(id: Int, english: String, japanese: String) {
//        val newItem = getNewItemEntry(id, english, japanese)
//        insertItem(newItem)
//    }
//
//    private fun getNewItemEntry(id: Int, english: String, japanese: String): Item{
//        return Item(
//            id = id,
//            english = english.toString(),
//            japanese = japanese.toString()
//        )
//    }
//
//    private fun insertItem(item: Item) {
//        viewModelScope.launch(Dispatchers.IO) {
//            itemDao.insert(item)
//        }
//    }
//}