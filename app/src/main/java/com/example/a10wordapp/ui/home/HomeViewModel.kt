package com.example.a10wordapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a10wordapp.repository.DataRepository
import com.example.a10wordapp.repository.InitialDataRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val dataRepository: DataRepository,
    private val initialDataRepository: InitialDataRepository
) : ViewModel() {

    private val _english = MutableLiveData<String>()
    val english: LiveData<String> get() = _english

    fun fetchAPI() {
        viewModelScope.launch {
            kotlin.runCatching { initialDataRepository.fetchInitialData() }
                .onSuccess { result ->
                    _english.value = result.data[2].english
                    dataRepository.saveInitialData(result.data)
                }
                .onFailure { result ->
                    Log.d("response", "debug ${result}")
                }
        }
    }
}