package com.example.a10wordapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a10wordapp.domain.item.QuizItem
import com.example.a10wordapp.repository.QuizWordRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val quizWordRepository: QuizWordRepository
) : ViewModel() {
    private var _plan = MutableLiveData<Boolean>(true)
    val plan: LiveData<Boolean> = _plan

    private val _quizItemArray = MutableLiveData<Array<QuizItem>>()
    val quizItemArray: LiveData<Array<QuizItem>> get() = _quizItemArray

    fun changePlan(isCheck: Boolean) {
        _plan.value = isCheck
    }

    fun registerQuizWords(planSwitch: Boolean, selectItem: Int) = viewModelScope.launch {
        runCatching { quizWordRepository.getQuizList(planSwitch) }
            .onSuccess { entity ->
                _quizItemArray.value = ListFiliter(entity, selectItem)
                    .toTypedArray()
            }
            .onFailure { result ->
                Log.d("response", "debug ${result}")
            }
    }

    private fun ListFiliter(entity: List<QuizItem>, index: Int): List<QuizItem> {
        val max = index * 10
        val min = max - 9
        return entity.filter { min <= it.id }
            .filter { it.id <= max }
    }
}