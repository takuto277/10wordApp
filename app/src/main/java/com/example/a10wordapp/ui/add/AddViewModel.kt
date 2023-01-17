package com.example.a10wordapp.ui.add

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.Repository.AddRepository
import com.example.a10wordapp.Repository.RoomRepository
import com.example.a10wordapp.databinding.ActivityAddBinding

class AddViewModel: ViewModel() {
    fun saveButtonTapped(context: Context, id:Int, english: String, japanese: String) {
        RoomRepository().addNewItem(context, id, english, japanese)
    }
}