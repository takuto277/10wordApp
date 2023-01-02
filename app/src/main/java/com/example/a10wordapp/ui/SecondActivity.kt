package com.example.a10wordapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.a10wordapp.databinding.ActivitySecondBinding
import android.widget.Toast



class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val array = arrayOf("one", "two", "three", "four", "five")
        var arrayFigure = 0

        binding = ActivitySecondBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)

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
    }
