package com.example.a10wordapp.ui.quiz

import android.os.Bundle
import androidx.core.view.isVisible
import android.widget.Toast
import com.example.a10wordapp.databinding.ActivityQuizBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a10wordapp.ViewModelFactory
import com.example.a10wordapp.data.ItemEntiry
import com.example.a10wordapp.repository.DataRepository
import com.example.a10wordapp.repository.QuizRepository

class QuizActivity : AppCompatActivity() {
    private val viewModel: QuizViewModel by viewModels{ViewModelFactory(applicationContext)}
    private lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var arrayFigure = 0

        // リストを取得する
        viewModel.getList(this)

        viewModel.list.observe(this, Observer {
            val itemList = viewModel.list.value ?: return@Observer
            getlayout(itemList, arrayFigure)
            binding.translateText.isVisible = false
        })

        binding.currentButton.setOnClickListener {
            val itemList = viewModel.list.value ?: return@setOnClickListener
            if (arrayFigure == itemList.count() - 1) {
                finish()
                Toast.makeText(this, "問題終了！", Toast.LENGTH_SHORT).show()
            } else {
                ++arrayFigure
            }

            getlayout(itemList, arrayFigure)
            binding.translateText.isVisible = false
        }

        binding.wrongButton.setOnClickListener {
            val itemList = viewModel.list.value ?: return@setOnClickListener

            arrayFigure = 0
            getlayout(itemList, arrayFigure)
            binding.translateText.isVisible = false
        }
        binding.hiddenButton.setOnClickListener {
            binding.translateText.isVisible = !binding.translateText.isVisible
        }
        binding.btnBack.setOnClickListener {
            finish()
        }

        viewModel.arrayFigure.observe(this, Observer {
            arrayFigure = viewModel.arrayFigure.value ?: return@Observer
        })
    }

    private fun getlayout(list: List<ItemEntiry>, arrayFigure: Int) {
        binding.wordText.text = list[arrayFigure].english
        binding.translateText.text = list[arrayFigure].japanese
    }
}

