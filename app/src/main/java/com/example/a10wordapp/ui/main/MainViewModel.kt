package com.example.a10wordapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a10wordapp.domain.entity.QuizShowEntity
import com.example.a10wordapp.repository.QuizWordRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val quizWordRepository: QuizWordRepository
) : ViewModel() {
    private var _plan = MutableLiveData<Boolean>()
    val plan: LiveData<Boolean> = _plan

    private val _quizShowWords = MutableLiveData<Array<QuizShowEntity>>()
    val quizShowWords: LiveData<Array<QuizShowEntity>> get() = _quizShowWords

    init {
        _plan.value = true
    }

    fun changePlan(isCheck: Boolean) {
        _plan.value = isCheck
    }

    fun registerQuizWords(planSwitch: Boolean, selectItem: Int) {
        viewModelScope.launch {
            runCatching { quizWordRepository.getList(planSwitch) }
                .onSuccess { entity ->
                    _quizShowWords.value = entity.map { entity ->
                        QuizShowEntity(
                            id = entity.id,
                            english = entity.english,
                            japanese = entity.japanese
                        )
                    }.filter { it.id in "${selectItem}0".toInt() - 9.."${selectItem}0".toInt() }
                        .toTypedArray()
                }
                .onFailure { result ->
                    Log.d("response", "debug ${result}")
                }
        }
    }
}