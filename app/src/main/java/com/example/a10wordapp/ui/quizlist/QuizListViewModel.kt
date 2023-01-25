package com.example.a10wordapp.ui.quizlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.domain.entity.QuizListItem
import com.example.a10wordapp.repository.DataRepository

class QuizListViewModel(
    private val dataRepository: DataRepository
) : ViewModel() {

    private val _quizListItem = MutableLiveData<Array<QuizListItem>>()
    val quizListItem: LiveData<Array<QuizListItem>> get() = _quizListItem

    fun fetchContent() {
        _quizListItem.value = dataRepository.getList().map { entity ->
            QuizListItem(text = "${entity.english} / ${entity.japanese}")
        }.toTypedArray()
    }
}