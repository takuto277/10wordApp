package com.example.a10wordapp.Repository

import com.example.a10wordapp.databinding.ActivityAddBinding

class AddRepository {
    fun id(binding: ActivityAddBinding): Int {
        val id = binding.id.text.toString().toInt()
        return id
    }

    fun englsih(binding: ActivityAddBinding): String {
        val english = binding.english.text.toString()
        return english
    }

    fun japanese(binding: ActivityAddBinding): String {
        val japanese = binding.japanese.text.toString()
        return japanese
    }
}