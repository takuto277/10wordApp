package com.example.a10wordapp.ui.quizselect

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.domain.entity.QuizSelectItem
import com.example.a10wordapp.repository.DataRepository

class QuizSelectViewModel(
    private val dataRepository: DataRepository
    ): ViewModel() {

        private val _quizSelectItem = MutableLiveData<Array<QuizSelectItem>>()
        val quizSelectItem: LiveData<Array<QuizSelectItem>> get() = _quizSelectItem

    fun fecthContent() {
        _quizSelectItem.value = dataRepository.getList().map { entey ->
            QuizSelectItem(text = "english:${entey.english}, japanese:${entey.japanese}")
        }.toTypedArray()
    }
    }