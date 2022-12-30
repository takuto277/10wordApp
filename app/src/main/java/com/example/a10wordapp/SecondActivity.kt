package com.example.a10wordapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.view.isVisible
import com.example.a10wordapp.databinding.ActivitySecondBinding



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
            ++arrayFigure
            binding.wordText.text = array[arrayFigure]
        }
        binding.wrongButton.setOnClickListener {
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
