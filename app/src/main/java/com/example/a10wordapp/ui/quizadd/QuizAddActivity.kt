package com.example.a10wordapp.ui.quizadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import com.example.a10wordapp.R
import com.example.a10wordapp.databinding.ActivityAddBinding
import com.example.a10wordapp.ui.ViewModelFactory
import com.example.a10wordapp.ui.home.HomeActivity

class QuizAddActivity : Fragment() {

    private val viewModel: QuizAddViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: ActivityAddBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveButton.setOnClickListener {
            //    val id = binding.id.text.toString().toInt()
            val english = binding.english.text.toString()
            val japanese = binding.japanese.text.toString()
            viewModel.saveButtonTapped(english, japanese)
            backScreen()
        }

        binding.backButton.setOnClickListener {
            backScreen()
        }
    }

    private fun backScreen() {
        val fragment = HomeActivity()
        val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)
        transaction.commit()
    }
}