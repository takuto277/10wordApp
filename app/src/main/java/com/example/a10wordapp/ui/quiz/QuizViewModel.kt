package com.example.a10wordapp.ui.quiz

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.data.ItemEntity
import com.example.a10wordapp.databinding.ActivityQuizBinding
import com.example.a10wordapp.repository.DataRepository
import com.example.a10wordapp.repository.QuizRepository

class QuizViewModel(
    private val dataRepository: DataRepository,
    private val quizRepository: QuizRepository
) : ViewModel() {

    private val _list = MutableLiveData<List<ItemEntity>>()
    val list: LiveData<List<ItemEntity>> get() = _list

    private val _arrayFigure = MutableLiveData<Int>()
    val arrayFigure: LiveData<Int> get() = _arrayFigure

    private val _checkFinish = MutableLiveData<Boolean>()
    val checkFinish: LiveData<Boolean> get() = _checkFinish

    fun getList(context: Context) {
        _list.value = dataRepository.getList()
    }

    fun setUp(binding: ActivityQuizBinding, arrayFigure: Int) {
        val itemList = list.value ?: return
        quizRepository.getLayout(binding, itemList, arrayFigure)
        quizRepository.resetVisible(binding)
    }

    fun rightAction(binding: ActivityQuizBinding, arrayFigure: Int) {
        val itemList = list.value ?: return
        _arrayFigure.value = quizRepository.rightAction(itemList, arrayFigure)
        //TODO: arrayFigureを更新してないから、UIが変化しない。
        // Observerで変更してからgetLayoutを呼ぶべき。眠いから明日やる。
        quizRepository.getLayout(binding, itemList, arrayFigure)
        quizRepository.resetVisible(binding)
    }

    fun chackFinish(arrayFigure: Int) {
        val itemList = list.value ?: return
        _checkFinish.value = quizRepository.checkFinish(itemList, arrayFigure)
    }
}