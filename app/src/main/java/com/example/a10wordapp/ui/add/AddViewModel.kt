package com.example.a10wordapp.ui.add

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.repository.DataRepository

class AddViewModel(
    private val dataRepository: DataRepository
): ViewModel() {
    fun saveButtonTapped(context: Context, id:Int, english: String, japanese: String) {
        dataRepository.addNewItem(context, id, english, japanese)
    }
}