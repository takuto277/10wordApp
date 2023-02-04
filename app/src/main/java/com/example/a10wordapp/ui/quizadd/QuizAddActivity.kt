package com.example.a10wordapp.ui.quizadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a10wordapp.databinding.ActivityAddBinding

class QuizAddActivity : Fragment() {

    private lateinit var binding: ActivityAddBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityAddBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.activity_home, container, false)
    }

//    private val viewModel: QuizAddViewModel by viewModels { ViewModelFactory(applicationContext) }
//    private lateinit var binding: ActivityAddBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityAddBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.saveButton.setOnClickListener {
//            val id = binding.id.text.toString().toInt()
//            val english = binding.english.text.toString()
//            val japanese = binding.japanese.text.toString()
//            viewModel.saveButtonTapped(id, english, japanese)
//            finish()
//        }
//
//        binding.backButton.setOnClickListener {
//            finish()
//        }
//    }
}