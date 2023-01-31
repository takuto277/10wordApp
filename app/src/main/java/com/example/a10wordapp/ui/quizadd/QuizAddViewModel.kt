package com.example.a10wordapp.ui.quizadd

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.repository.DataRepository

class QuizAddViewModel(
    private val dataRepository: DataRepository
) : ViewModel() {
    fun saveButtonTapped(context: Context, id: Int, english: String, japanese: String) {
        dataRepository.addNewItem(id, english, japanese)
    }
}