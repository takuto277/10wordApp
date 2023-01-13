package com.example.a10wordapp.ui.quiz

import android.os.Bundle
import androidx.core.view.isVisible
import android.widget.Toast
import com.example.a10wordapp.databinding.ActivityQuizBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.a10wordapp.Data.Item


class QuizActivity :  AppCompatActivity() {
    private val viewModel: QuizViewModel by viewModels()
    private lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = viewModel.getList(this)
        var arrayFigure = 0
        getlayout(list, arrayFigure)
        binding.translateText.isVisible = false

        binding.rightButton.setOnClickListener {
            binding.translateText.isVisible = false
            if (arrayFigure==list.count()-1){
                Toast.makeText(applicationContext, "問題終了！", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                ++arrayFigure
                getlayout(list, arrayFigure)
            }
        }
        binding.wrongButton.setOnClickListener {
            binding.translateText.isVisible = false
            arrayFigure = 0
            getlayout(list, arrayFigure)
        }
        binding.hiddenButton.setOnClickListener {
            if (binding.translateText.isVisible) {
                binding.translateText.isVisible = false
            } else {
                binding.translateText.isVisible = true
            }
        }
            binding.btnBack.setOnClickListener {
                finish()
            }
        }

    private fun getlayout(list: List<Item>, arrayFigure: Int) {
        binding.wordText.text = list[arrayFigure].english
        binding.translateText.text = list[arrayFigure].japanese
    }
}
