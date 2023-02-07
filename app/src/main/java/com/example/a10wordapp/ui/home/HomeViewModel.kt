package com.example.a10wordapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a10wordapp.repository.InitialQuizWordRepository
import com.example.a10wordapp.repository.QuizWordRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val quizWordRepository: QuizWordRepository,
    private val initialQuizWordRepository: InitialQuizWordRepository
) : ViewModel() {

    private val _english = MutableLiveData<String>()
    val english: LiveData<String> get() = _english

    fun fetchInitialWords() = viewModelScope.launch {
        runCatching { initialQuizWordRepository.fetchInitialData() }
            .onSuccess { result ->
                _english.value = result.data[2].english
                quizWordRepository.saveInitialData(result.data)
            }
            .onFailure { result ->
                Log.d("response", "debug ${result}")
            }
    }
}