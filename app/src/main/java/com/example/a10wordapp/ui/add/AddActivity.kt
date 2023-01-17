package com.example.a10wordapp.ui.add

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.a10wordapp.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    private val viewModel: AddViewModel by viewModels()
    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val id = binding.id.text.toString().toInt()
            val english = binding.english.text.toString()
            val japanese = binding.japanese.text.toString()
            viewModel.saveButtonTapped(this, id, english, japanese)
            finish()
        }

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}