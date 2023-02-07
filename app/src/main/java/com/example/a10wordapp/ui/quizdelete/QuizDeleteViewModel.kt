package com.example.a10wordapp.ui.quizdelete

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a10wordapp.data.db.entity.InitialDataEntity
import com.example.a10wordapp.domain.item.QuizItem
import com.example.a10wordapp.repository.QuizWordRepository
import kotlinx.coroutines.launch

class QuizDeleteViewModel(
    private val quizWordRepository: QuizWordRepository
) : ViewModel() {

    private val _list = MutableLiveData<List<InitialDataEntity>>()
    val list: LiveData<List<InitialDataEntity>> get() = _list

    private val _quizItemArray = MutableLiveData<Array<QuizItem>>()
    val quizItemArray: LiveData<Array<QuizItem>> get() = _quizItemArray

    fun getArray(planSwitch: Boolean) {
        viewModelScope.launch {
            runCatching { quizWordRepository.getList(planSwitch) }
                .onSuccess { result ->
                    _quizItemArray.value = result.toTypedArray()
                }
                .onFailure { result ->
                    Log.d("response", "debug ${result}")
                }
        }
    }
}