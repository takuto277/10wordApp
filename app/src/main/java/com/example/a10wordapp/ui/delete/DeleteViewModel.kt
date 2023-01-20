package com.example.a10wordapp.ui.delete

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.data.ItemEntiry
import com.example.a10wordapp.repository.DataRepository
import com.example.a10wordapp.repository.QuizRepository

class DeleteViewModel(
    private val dataRepository: DataRepository
)
: ViewModel() {

    private val _list = MutableLiveData<List<ItemEntiry>>()
    val list: LiveData<List<ItemEntiry>> get() = _list

    fun getList(context: Context) {
        _list.value = dataRepository.getList(context)
    }
}