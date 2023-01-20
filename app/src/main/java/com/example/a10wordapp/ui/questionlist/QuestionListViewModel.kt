package com.example.a10wordapp.ui.questionlist

import android.content.Context
import android.widget.ListView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.data.ItemEntiry
import com.example.a10wordapp.repository.AddArrayRepository
import com.example.a10wordapp.repository.GetListViewRepository
import com.example.a10wordapp.repository.DataRepository

class QuestionListViewModel(
    private val dataRepository: DataRepository,
    private val getListViewRepository: GetListViewRepository,
    private val addArrayRepository: AddArrayRepository
) : ViewModel() {

    private val mutableLiveDataListView = MutableLiveData<ListView>()
    val listViewLiveData: LiveData<ListView> get() = mutableLiveDataListView

    private val mutableLiveDataList = MutableLiveData<List<ItemEntiry>>()
    val listLiveData: LiveData<List<ItemEntiry>> get() = mutableLiveDataList

    private val mutableLiveDataArray = MutableLiveData<Array<String>>()
    val arrayLiveData: LiveData<Array<String>> get() = mutableLiveDataArray

    fun getListView(context: Context) {
        mutableLiveDataListView.value = getListViewRepository.getListView(context)
    }

    fun getList(context: Context) {
        mutableLiveDataList.value = dataRepository.getList(context)
    }

    fun getArrayList(list: List<ItemEntiry>) {
        mutableLiveDataArray.value = addArrayRepository.addArray(list)
    }

    fun getAdapter(listView: ListView, context: Context, array: Array<String>) {
        val adapter = getListViewRepository.getAdapter(context, array)
        listView.adapter = adapter
    }
}