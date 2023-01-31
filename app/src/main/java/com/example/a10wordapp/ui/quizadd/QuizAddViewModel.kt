package com.example.a10wordapp.ui.quizadd

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.repository.QuizWordRepository

class QuizAddViewModel(
    private val quizWordRepository: QuizWordRepository
) : ViewModel() {
    fun saveButtonTapped(context: Context, id: Int, english: String, japanese: String) {
        quizWordRepository.addNewItem(id, english, japanese)
    }
}