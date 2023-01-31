package com.example.a10wordapp.ui.quizshow

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.data.db.entity.ItemEntity
import com.example.a10wordapp.repository.QuizWordRepository

class QuizShowViewModel(
    private val quizWordRepository: QuizWordRepository
) : ViewModel() {

    private val _list = MutableLiveData<List<ItemEntity>>()
    val list: LiveData<List<ItemEntity>> get() = _list

    fun getList() {
        _list.value = quizWordRepository.getList()
    }
}