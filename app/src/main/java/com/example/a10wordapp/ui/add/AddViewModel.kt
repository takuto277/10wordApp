package com.example.a10wordapp.ui.add

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.a10wordapp.Repository.AddRepository
import com.example.a10wordapp.Repository.RoomRepository
import com.example.a10wordapp.databinding.ActivityAddBinding

class AddViewModel: ViewModel() {
    fun saveItem(context: Context, binding: ActivityAddBinding) {
        val id = AddRepository().id(binding)
        val english = AddRepository().englsih(binding)
        val japanese = AddRepository().englsih(binding)
        RoomRepository().addNewItem(context, id, english, japanese)
    }
}