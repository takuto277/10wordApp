package com.example.a10wordapp.ui.quizadd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a10wordapp.repository.QuizWordRepository
import kotlinx.coroutines.launch

class QuizAddViewModel(
    private val quizWordRepository: QuizWordRepository
) : ViewModel() {
    fun saveButtonTapped(english: String, japanese: String) {
        viewModelScope.launch {
            quizWordRepository.addNewItem(english, japanese)
        }
    }
}