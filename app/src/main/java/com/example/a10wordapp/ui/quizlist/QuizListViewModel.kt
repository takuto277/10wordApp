package com.example.a10wordapp.ui.quizlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a10wordapp.domain.item.QuizListItem
import com.example.a10wordapp.repository.QuizWordRepository
import com.example.a10wordapp.ui.main.QuizPlan
import kotlinx.coroutines.launch

class QuizListViewModel(
    private val quizWordRepository: QuizWordRepository
) : ViewModel() {

    private val _quizListItem = MutableLiveData<Array<QuizListItem>>()
    val quizListItem: LiveData<Array<QuizListItem>> get() = _quizListItem

    fun fetchContent(quizPlan: QuizPlan) = viewModelScope.launch {
        runCatching { quizWordRepository.getQuizList(quizPlan) }
            .onSuccess { result ->
                _quizListItem.value = result.map { entity ->
                    QuizListItem(text = "${entity.english} / ${entity.japanese}")
                }.toTypedArray()
            }
            .onFailure { result ->
                Log.d("response", "debug ${result}")
            }
    }
}