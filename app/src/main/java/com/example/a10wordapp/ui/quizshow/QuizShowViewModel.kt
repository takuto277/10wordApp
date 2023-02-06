package com.example.a10wordapp.ui.quizshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.repository.QuizWordRepository

class QuizShowViewModel(
    private val quizWordRepository: QuizWordRepository
) : ViewModel() {

    private val _list = MutableLiveData<String>()
    val list: LiveData<String> get() = _list
}