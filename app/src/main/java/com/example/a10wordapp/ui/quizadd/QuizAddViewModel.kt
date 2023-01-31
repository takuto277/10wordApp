package com.example.a10wordapp.ui.quizadd

import androidx.lifecycle.ViewModel
import com.example.a10wordapp.repository.QuizWordRepository

class QuizAddViewModel(
    private val quizWordRepository: QuizWordRepository
) : ViewModel() {
    fun saveButtonTapped(id: Int, english: String, japanese: String) {
        quizWordRepository.addNewItem(id, english, japanese)
    }
}