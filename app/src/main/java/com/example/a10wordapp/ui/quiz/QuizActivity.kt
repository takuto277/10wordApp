package com.example.a10wordapp.ui.quiz

import android.os.Bundle
import androidx.core.view.isVisible
import android.widget.Toast
import com.example.a10wordapp.databinding.ActivityQuizBinding
import com.example.a10wordapp.ui.base.BaseActivity
import androidx.activity.viewModels


class QuizActivity :  BaseActivity() {
    private val viewModel: QuizViewModel by viewModels()
    private lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val array = arrayOf("one", "two", "three", "four", "five")
        var arrayFigure = 0

        binding.wordText.text = array[arrayFigure]
        binding.translateText.isVisible = false

        binding.rightButton.setOnClickListener {
            binding.translateText.isVisible = false
            if (arrayFigure==array.count()-1){
                Toast.makeText(applicationContext, "問題終了！", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                ++arrayFigure
                binding.wordText.text = array[arrayFigure]
            }
        }
        binding.wrongButton.setOnClickListener {
            binding.translateText.isVisible = false
            arrayFigure = 0
            binding.wordText.text = array[arrayFigure]
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

    override fun initViewBinding() {
        binding = ActivityQuizBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}
