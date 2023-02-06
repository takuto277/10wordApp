package com.example.a10wordapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _plan = MutableLiveData<Boolean>()
    val plan: LiveData<Boolean> = _plan

    init {
        _plan.value = true
    }

    fun changePlan(isCheck: Boolean) {
        _plan.value = isCheck
    }
}