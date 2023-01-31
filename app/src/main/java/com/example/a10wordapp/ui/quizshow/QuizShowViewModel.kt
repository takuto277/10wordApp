package com.example.a10wordapp.ui.quizshow

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.data.db.entity.ItemEntity
import com.example.a10wordapp.databinding.ActivityQuizBinding
import com.example.a10wordapp.repository.DataRepository

class QuizShowViewModel(
    private val dataRepository: DataRepository
) : ViewModel() {

    private val _list = MutableLiveData<List<ItemEntity>>()
    val list: LiveData<List<ItemEntity>> get() = _list

    fun getList(context: Context) {
        _list.value = dataRepository.getList()
    }
}