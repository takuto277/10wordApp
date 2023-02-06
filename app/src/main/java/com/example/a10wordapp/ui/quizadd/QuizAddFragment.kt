package com.example.a10wordapp.ui.quizadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import com.example.a10wordapp.R
import com.example.a10wordapp.databinding.QuizAddFragmentBinding
import com.example.a10wordapp.ui.ViewModelFactory
import com.example.a10wordapp.ui.home.HomeFragment

class QuizAddFragment : Fragment() {

    private val viewModel: QuizAddViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: QuizAddFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = QuizAddFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveButton.setOnClickListener {
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
        val fragment = HomeFragment()
        val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null);
        transaction.commit()
    }
}