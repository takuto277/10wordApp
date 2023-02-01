package com.example.a10wordapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a10wordapp.repository.QuizWordRepository
import com.example.a10wordapp.repository.InitialQuizWordRepository
import kotlinx.coroutines.launch

interface HomeViewModel {
    val english: LiveData<String>
    fun fetchAPI()
}

class HomeViewModelImpl(
    private val quizWordRepository: QuizWordRepository,
    private val initialQuizWordRepository: InitialQuizWordRepository
) : ViewModel(),HomeViewModel {

    private val _english = MutableLiveData<String>()
    override val english: LiveData<String> get() = _english

    override fun fetchAPI() {
        viewModelScope.launch {
            kotlin.runCatching { initialQuizWordRepository.fetchInitialData() }
                .onSuccess { result ->
                    _english.value = result.data[2].english
                    quizWordRepository.saveInitialData(result.data)
                }
                .onFailure { result ->
                    Log.d("response", "debug ${result}")
                }
        }
    }
}