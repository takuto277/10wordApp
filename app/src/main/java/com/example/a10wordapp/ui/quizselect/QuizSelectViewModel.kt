package com.example.a10wordapp.ui.quizselect

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.domain.entity.QuizSelectItem
import com.example.a10wordapp.repository.QuizWordRepository

class QuizSelectViewModel(
    private val quizWordRepository: QuizWordRepository
) : ViewModel() {

    private val _quizSelectItem = MutableLiveData<Array<QuizSelectItem>>()
    val quizSelectItem: LiveData<Array<QuizSelectItem>> get() = _quizSelectItem

    fun fecthContent() {
        _quizSelectItem.value = quizWordRepository.getList().map { entey ->
            QuizSelectItem(text = "english:${entey.english}, japanese:${entey.japanese}")
        }.toTypedArray()
    }
}