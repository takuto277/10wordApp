package com.example.a10wordapp.ui.list

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.Data.ItemEntiry
import com.example.a10wordapp.Data.ItemRoomDatabase
import com.example.a10wordapp.Repository.getListRepository
import kotlinx.coroutines.runBlocking

open class ListViewModel: ViewModel() {
    fun hoge(context: Context): List<ItemEntiry> {
        val getListRepository = getListRepository(ItemRoomDatabase.getDatabase(context))
        var list = getListRepository.getList(context)
        return list
        //TODO:返り値を使わずにobserveを実装する予定
    }

}