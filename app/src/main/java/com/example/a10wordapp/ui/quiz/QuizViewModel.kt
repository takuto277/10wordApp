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

    private val mutableLiveDataList = MutableLiveData<List<ItemEntiry>>()
    val listLiveData: LiveData<List<ItemEntiry>> get() = mutableLiveDataList

    private val mutableLiveDataArrayFigure = MutableLiveData<Int>()
    val arrayFigureLiveData: LiveData<Int> get() = mutableLiveDataArrayFigure

    private val mutableLiveDataCheckFinish = MutableLiveData<Boolean>()
    val checkFinishLiveData: LiveData<Boolean> get() = mutableLiveDataCheckFinish

    fun getList(context: Context){
        mutableLiveDataList.value = RoomRepository().getList(context)
    }

    fun setUp(binding: ActivityQuizBinding, arrayFigure: Int) {
        val itemList = listLiveData.value ?: return
        QuizRepository().getLayout(binding, itemList, arrayFigure)
        QuizRepository().resetVisible(binding)
    }

    fun rightAction(binding: ActivityQuizBinding, arrayFigure: Int) {
        val itemList = listLiveData.value ?: return
        mutableLiveDataArrayFigure.value = QuizRepository().rightAction(itemList, arrayFigure)
        //TODO: arrayFigureを更新してないから、UIが変化しない。
        // Observerで変更してからgetLayoutを呼ぶべき。眠いから明日やる。
        QuizRepository().getLayout(binding, itemList, arrayFigure)
        QuizRepository().resetVisible(binding)
    }

    fun chackFinish(arrayFigure: Int) {
        val itemList = listLiveData.value ?: return
        mutableLiveDataCheckFinish.value = QuizRepository().checkFinish(itemList, arrayFigure)
    }
}