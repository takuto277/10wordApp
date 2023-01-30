package com.example.a10wordapp.ui.delete

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.data.InitialDataEntity
import com.example.a10wordapp.data.ItemEntity
import com.example.a10wordapp.repository.DataRepository
import com.example.a10wordapp.repository.QuizRepository

class DeleteViewModel(
    private val dataRepository: DataRepository
)
: ViewModel() {

    private val _list = MutableLiveData<List<InitialDataEntity>>()
    val list: LiveData<List<InitialDataEntity>> get() = _list

    fun getInitialDataList(context: Context) {
        _list.value = dataRepository.getInitialDataList()
    }
}