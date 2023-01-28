package com.example.a10wordapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.data.ItemEntiry
import com.example.a10wordapp.repository.InitialDataRepository

class HomeViewModel(
    private val initialDataRepository: InitialDataRepository
) : ViewModel(){

    private val _english = MutableLiveData<String>()
    val english: LiveData<String> get() = _english

    fun fetchAPI() {
        _english.value = initialDataRepository.fetchInitialData()
    }
}