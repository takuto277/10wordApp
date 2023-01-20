package com.example.a10wordapp.ui.questionlist

import android.content.Context
import android.widget.ListView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.data.ItemEntiry
import com.example.a10wordapp.domain.entity.QuestionListItem
import com.example.a10wordapp.repository.AddArrayRepository
import com.example.a10wordapp.repository.GetListViewRepository
import com.example.a10wordapp.repository.DataRepository

class QuestionListViewModel(
    private val dataRepository: DataRepository
) : ViewModel() {

    private val _questionListItem = MutableLiveData<Array<QuestionListItem>>()
    val questionListItem: LiveData<Array<QuestionListItem>> get() = _questionListItem

    fun fetchContent() {
        _questionListItem.value = dataRepository.getList().map { entity ->
            QuestionListItem(text = "${entity.english} / ${entity.japanese}")
        }.toTypedArray()
    }
}