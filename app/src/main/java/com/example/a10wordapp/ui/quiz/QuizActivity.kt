package com.example.a10wordapp.ui.quiz

import android.os.Bundle
import androidx.core.view.isVisible
import android.widget.Toast
import com.example.a10wordapp.databinding.ActivityQuizBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.a10wordapp.Data.ItemEntiry


class QuizActivity :  AppCompatActivity() {
    private val viewModel: QuizViewModel by viewModels()
    private lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var arrayFigure = 0

        // リストを取得する
        viewModel.getList(this)

        viewModel.listLiveData.observe(this, Observer {
            viewModel.setUp(binding, arrayFigure)
        })

        binding.rightButton.setOnClickListener {
            viewModel.rightAction(binding, arrayFigure)
            viewModel.chackFinish(arrayFigure)
        }

        binding.wrongButton.setOnClickListener {
            binding.translateText.isVisible = false
            val itemList = viewModel.listLiveData.value ?: return@setOnClickListener

            arrayFigure = 0
            getlayout(itemList, arrayFigure)
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
        viewModel.arrayFigureLiveData.observe(this, Observer {
            arrayFigure = viewModel.arrayFigureLiveData.value ?: return@Observer
        })

        viewModel.checkFinishLiveData.observe(this, Observer {
            Toast.makeText(this, "問題終了！", Toast.LENGTH_SHORT).show()
        //    finish()
        })
        }

    private fun getlayout(list: List<ItemEntiry>, arrayFigure: Int) {
        binding.wordText.text = list[arrayFigure].english
        binding.translateText.text = list[arrayFigure].japanese
    }

}
