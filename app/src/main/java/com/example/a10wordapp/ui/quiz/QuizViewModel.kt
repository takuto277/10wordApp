package com.example.a10wordapp.ui.quiz

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.Data.ItemEntiry
import com.example.a10wordapp.Data.ItemRoomDatabase
import com.example.a10wordapp.Repository.QuizRepository
import com.example.a10wordapp.Repository.RoomRepository
import com.example.a10wordapp.databinding.ActivityQuizBinding
import kotlinx.coroutines.runBlocking

open class
QuizViewModel : ViewModel(){

    private val _list = MutableLiveData<List<ItemEntiry>>()
    val list: LiveData<List<ItemEntiry>> get() = _list

    private val _arrayFigure = MutableLiveData<Int>()
    val arrayFigure: LiveData<Int> get() = _arrayFigure

    private val _checkFinish = MutableLiveData<Boolean>()
    val checkFinish: LiveData<Boolean> get() = _checkFinish

    fun getList(context: Context){
        _list.value = RoomRepository().getList(context)
    }

    fun setUp(binding: ActivityQuizBinding, arrayFigure: Int) {
        val itemList = list.value ?: return
        QuizRepository().getLayout(binding, itemList, arrayFigure)
        QuizRepository().resetVisible(binding)
    }

    fun rightAction(binding: ActivityQuizBinding, arrayFigure: Int) {
        val itemList = list.value ?: return
        _arrayFigure.value = QuizRepository().rightAction(itemList, arrayFigure)
        //TODO: arrayFigureを更新してないから、UIが変化しない。
        // Observerで変更してからgetLayoutを呼ぶべき。眠いから明日やる。
        QuizRepository().getLayout(binding, itemList, arrayFigure)
        QuizRepository().resetVisible(binding)
    }

    fun chackFinish(arrayFigure: Int) {
        val itemList = list.value ?: return
        _checkFinish.value = QuizRepository().checkFinish(itemList, arrayFigure)
    }
}