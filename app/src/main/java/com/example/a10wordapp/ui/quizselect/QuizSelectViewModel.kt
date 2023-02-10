package com.example.a10wordapp.ui.quizselect

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a10wordapp.domain.item.QuizSelectItem
import com.example.a10wordapp.repository.QuizWordRepository
import com.example.a10wordapp.ui.main.QuizPlan
import kotlinx.coroutines.launch

class QuizSelectViewModel(
    private val quizWordRepository: QuizWordRepository
) : ViewModel() {

    private val _quizSelectItem = MutableLiveData<Array<QuizSelectItem>>()
    val quizSelectItem: LiveData<Array<QuizSelectItem>> get() = _quizSelectItem

    fun fecthContent(quizPlan: QuizPlan) = viewModelScope.launch {
        runCatching { quizWordRepository.getQuizList(quizPlan) }
            .onSuccess { entity ->
                _quizSelectItem.value = entity.map { entity ->
                    QuizSelectItem(
                        id = entity.id,
                    )
                }.toTypedArray()
            }
            .onFailure { result ->
                Log.d("response", "debug ${result}")
            }
    }
}