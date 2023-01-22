//package com.example.a10wordapp.ui.selectQuiz
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.example.a10wordapp.data.ItemEntiry
//import com.example.a10wordapp.domain.entity.QuestionListItem
//import com.example.a10wordapp.repository.DataRepository
//
//class QuizSelectViewModel (private val dataRepository: DataRepository
//) : ViewModel() {
//
//    private val _questionListItem = MutableLiveData<List<ItemEntiry>>()
//    val questionListItem: LiveData<List<ItemEntiry>> get() = _questionListItem
//
//    fun fetchContent() {
//        _questionListItem.value = dataRepository.getList()
//    }
//}