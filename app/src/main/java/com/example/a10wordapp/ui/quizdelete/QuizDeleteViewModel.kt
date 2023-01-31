package com.example.a10wordapp.ui.quizdelete

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.data.db.entity.InitialDataEntity
import com.example.a10wordapp.repository.DataRepository

class QuizDeleteViewModel(
    private val dataRepository: DataRepository
) : ViewModel() {

    private val _list = MutableLiveData<List<InitialDataEntity>>()
    val list: LiveData<List<InitialDataEntity>> get() = _list

    fun getInitialDataList(context: Context) {
        _list.value = dataRepository.getInitialDataList()
    }
}