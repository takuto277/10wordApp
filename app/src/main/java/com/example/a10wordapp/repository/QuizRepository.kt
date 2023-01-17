package com.example.a10wordapp.repository

import androidx.core.view.isVisible
import com.example.a10wordapp.Data.ItemEntiry
import com.example.a10wordapp.databinding.ActivityQuizBinding

class QuizRepository {
    fun getLayout(binding: ActivityQuizBinding, itemList: List<ItemEntiry>, arrayFigure: Int) {
        binding.wordText.text = itemList[arrayFigure].english
        binding.translateText.text = itemList[arrayFigure].japanese
    }

    fun resetVisible(binding: ActivityQuizBinding) {
        binding.translateText.isVisible = false
    }

    fun rightAction(itemList: List<ItemEntiry>, arrayFigure: Int): Int{
        if (arrayFigure==itemList.count()-1){
        return arrayFigure
               } else {
            return +arrayFigure
        }
    }

    fun checkFinish(itemList: List<ItemEntiry>, arrayFigure: Int): Boolean {
        return arrayFigure==itemList.count()-1
    }
}