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
            viewModel.saveItem(this, binding)
            finish()
        }

        binding.backButton.setOnClickListener{
            finish()
        }
    }
}