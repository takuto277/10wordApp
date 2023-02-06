package com.example.a10wordapp.ui.quizshow

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.a10wordapp.R
import com.example.a10wordapp.databinding.QuizShowFragmentBinding
import com.example.a10wordapp.domain.entity.QuizShowEntity
import com.example.a10wordapp.ui.ViewModelFactory
import com.example.a10wordapp.ui.home.HomeFragment
import com.example.a10wordapp.ui.main.MainViewModel
import com.example.a10wordapp.ui.quizshow.speechListener.SpeechListener
import java.util.*

class QuizShowFragment : Fragment(), TextToSpeech.OnInitListener {

    private val mainViewModel: MainViewModel by activityViewModels { ViewModelFactory(requireContext()) }
    private val viewModel: QuizShowViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: QuizShowFragmentBinding
    private var textToSpeech: TextToSpeech? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = QuizShowFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var arrayFigure = 0

        textToSpeech = TextToSpeech(requireContext(), this)

        // リストを取得する
        val fileterQuizArray = mainViewModel.quizShowWords.value ?: return
        getlayout(fileterQuizArray, arrayFigure)
        speakText(fileterQuizArray, arrayFigure)
        binding.translateText.isVisible = false

        binding.currentButton.setOnClickListener {
            if (arrayFigure == fileterQuizArray.count() - 1) {
                backScreen()
                Toast.makeText(requireContext(), "問題終了！", Toast.LENGTH_SHORT).show()
            } else {
                ++arrayFigure
            }

            getlayout(fileterQuizArray, arrayFigure)
            speakText(fileterQuizArray, arrayFigure)
            binding.translateText.isVisible = false
        }

        binding.wrongButton.setOnClickListener {
            arrayFigure = 0
            getlayout(fileterQuizArray, arrayFigure)
            speakText(fileterQuizArray, arrayFigure)
            binding.translateText.isVisible = false
        }

        binding.hiddenButton.setOnClickListener {
            binding.translateText.isVisible = !binding.translateText.isVisible
        }

        binding.btnBack.setOnClickListener {
            backScreen()
        }
    }

    override fun onInit(p0: Int) {
        val listenter: SpeechListener = SpeechListener()
        textToSpeech!!.setOnUtteranceProgressListener(listenter)
    }

    private fun getlayout(array: Array<QuizShowEntity>, arrayFigure: Int) {
        binding.wordText.text = array[arrayFigure].english
        binding.translateText.text = array[arrayFigure].japanese
    }

    private fun speakText(array: Array<QuizShowEntity>, arrayFigure: Int) {
        textToSpeech!!.setLanguage(Locale.ENGLISH)
        textToSpeech!!.speak(array[arrayFigure].english, TextToSpeech.QUEUE_FLUSH, null, "Speech1")
    }

    private fun backScreen() {
        val fragment = HomeFragment()
        val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)
        transaction.commit()
    }
}

