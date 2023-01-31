package com.example.a10wordapp.ui.quiz

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.a10wordapp.data.ItemEntity
import com.example.a10wordapp.databinding.ActivityQuizBinding
import com.example.a10wordapp.ui.ViewModelFactory
import com.example.a10wordapp.ui.quiz.speechListener.SpeechListener
import java.util.*

class QuizActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private val viewModel: QuizViewModel by viewModels { ViewModelFactory(applicationContext) }
    private lateinit var binding: ActivityQuizBinding
    private var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var arrayFigure = 0

        val item = intent.getStringExtra("Item")

        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textToSpeech = TextToSpeech(this, this)

        // リストを取得する
        viewModel.getList(this)
        val itemList = viewModel.list.value ?: return

        viewModel.list.observe(this, Observer {
            getlayout(itemList, arrayFigure)
            speakText(itemList, arrayFigure)
            binding.translateText.isVisible = false

        })

        binding.currentButton.setOnClickListener {
            if (arrayFigure == itemList.count() - 1) {
                finish()
                Toast.makeText(this, "問題終了！", Toast.LENGTH_SHORT).show()
            } else {
                ++arrayFigure
            }

            getlayout(itemList, arrayFigure)
            speakText(itemList, arrayFigure)
            binding.translateText.isVisible = false
        }

        binding.wrongButton.setOnClickListener {
            arrayFigure = 0
            getlayout(itemList, arrayFigure)
            speakText(itemList, arrayFigure)
            binding.translateText.isVisible = false
        }

        binding.hiddenButton.setOnClickListener {
            binding.translateText.isVisible = !binding.translateText.isVisible
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    override fun onInit(p0: Int) {
        val listenter: SpeechListener = SpeechListener()
        textToSpeech!!.setOnUtteranceProgressListener(listenter)
    }

    private fun getlayout(list: List<ItemEntity>, arrayFigure: Int) {
        binding.wordText.text = list[arrayFigure].english
        binding.translateText.text = list[arrayFigure].japanese
    }

    private fun speakText(list: List<ItemEntity>, arrayFigure: Int) {
        textToSpeech!!.setLanguage(Locale.ENGLISH)
        textToSpeech!!.speak(list[arrayFigure].english, TextToSpeech.QUEUE_FLUSH, null, "Speech1")
    }
}

