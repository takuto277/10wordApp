package com.example.a10wordapp.ui.list

import android.content.Context
import android.widget.ListView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.Data.ItemEntiry
import com.example.a10wordapp.Repository.AddArrayRepository
import com.example.a10wordapp.Repository.GetListViewRepository
import com.example.a10wordapp.Repository.RoomRepository

open class ListViewModel: ViewModel() {
    private val mutableLiveData = MutableLiveData<String>()
    private val mutableLiveDataList = MutableLiveData<List<ItemEntiry>>()
    val liveData: LiveData<String> = mutableLiveData
    val listLiveData: LiveData<List<ItemEntiry>> = mutableLiveDataList
    fun hoge() {
        mutableLiveData.value = "なんか起きた"
    }
    fun getList(context: Context): List<ItemEntiry> {
        var list = RoomRepository().getList(context)
        mutableLiveDataList.value = RoomRepository().getList(context)
            return list
        //TODO:返り値を使わずにobserveを実装する予定
    }

    fun getListView(context: Context): ListView{
        var listView = GetListViewRepository().getListView(context)

        return  listView
    }

    fun getAdapter(listView: ListView, context: Context, array: Array<String>) {
        val adapter = GetListViewRepository().getAdapter(context, array)
        listView.adapter = adapter
    }

    fun getArrayList(list: List<ItemEntiry>): Array<String> {
        val array = AddArrayRepository().addArray(list)
        return array
    }

}