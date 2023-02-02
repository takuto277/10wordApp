package com.example.a10wordapp.ui.quizshow

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.a10wordapp.data.db.entity.InitialDataEntity
import com.example.a10wordapp.data.db.entity.ItemEntity
import com.example.a10wordapp.databinding.ActivityQuizBinding
import com.example.a10wordapp.ui.ViewModelFactory
import com.example.a10wordapp.ui.quizshow.speechListener.SpeechListener
import java.util.*

class QuizShowActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private val viewModel: QuizShowViewModel by viewModels { ViewModelFactory(applicationContext) }
    private lateinit var binding: ActivityQuizBinding
    private var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var arrayFigure = 0

        val item = intent.getIntExtra("ItemId",1)

        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textToSpeech = TextToSpeech(this, this)

        // リストを取得する
        viewModel.getInitialDataList()
        var fileterList: List<InitialDataEntity> = viewModel.list.value ?: return
   //     fileterList = fileterList.filter { it.id in "${item}0".toInt()-9.."${item}0".toInt() }

        viewModel.list.observe(this, Observer { list ->
            fileterList = list.filter { it.id in "${item}0".toInt()-9.."${item}0".toInt() }
            getlayout(fileterList, arrayFigure)
            speakText(fileterList, arrayFigure)
            binding.translateText.isVisible = false

        })

        binding.currentButton.setOnClickListener {
            if (arrayFigure == fileterList.count() - 1) {
                finish()
                Toast.makeText(this, "問題終了！", Toast.LENGTH_SHORT).show()
            } else {
                ++arrayFigure
            }

            getlayout(fileterList, arrayFigure)
            speakText(fileterList, arrayFigure)
            binding.translateText.isVisible = false
        }

        binding.wrongButton.setOnClickListener {
            arrayFigure = 0
            getlayout(fileterList, arrayFigure)
            speakText(fileterList, arrayFigure)
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

    private fun getlayout(list: List<InitialDataEntity>, arrayFigure: Int) {
        binding.wordText.text = list[arrayFigure].english
        binding.translateText.text = list[arrayFigure].japanese
    }

    private fun speakText(list: List<InitialDataEntity>, arrayFigure: Int) {
        textToSpeech!!.setLanguage(Locale.ENGLISH)
        textToSpeech!!.speak(list[arrayFigure].english, TextToSpeech.QUEUE_FLUSH, null, "Speech1")
    }
}

