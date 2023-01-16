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

    private val mutableLiveDataListView = MutableLiveData<ListView>()
     val listViewLiveData : LiveData<ListView> get() = mutableLiveDataListView

    private val mutableLiveDataList = MutableLiveData<List<ItemEntiry>>()
    val listLiveData: LiveData<List<ItemEntiry>> get() = mutableLiveDataList

    private val mutableLiveDataArray = MutableLiveData<Array<String>>()
    val arrayLiveData: LiveData<Array<String>> get() = mutableLiveDataArray

    fun getListView(context: Context){
        mutableLiveDataListView.value = GetListViewRepository().getListView(context)
    }

    fun getList(context: Context){
        mutableLiveDataList.value = RoomRepository().getList(context)
    }

    fun getArrayList(list: List<ItemEntiry>){
        mutableLiveDataArray.value = AddArrayRepository().addArray(list)
    }

    fun getAdapter(listView: ListView, context: Context, array: Array<String>) {
        val adapter = GetListViewRepository().getAdapter(context, array)
        listView.adapter = adapter
    }
}