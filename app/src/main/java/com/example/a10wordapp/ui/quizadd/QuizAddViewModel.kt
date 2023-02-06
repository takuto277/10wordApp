package com.example.a10wordapp.ui.quizadd

import androidx.lifecycle.ViewModel
import com.example.a10wordapp.repository.QuizWordRepository

class QuizAddViewModel(
    private val quizWordRepository: QuizWordRepository
) : ViewModel() {
    fun saveButtonTapped(english: String, japanese: String) {
        quizWordRepository.addNewItem(english, japanese)
    }
}