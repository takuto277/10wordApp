package com.example.a10wordapp.ui.add

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.a10wordapp.R
import com.example.a10wordapp.databinding.ActivityAddBinding
import com.example.a10wordapp.ui.add.AddViewModel
import com.example.a10wordapp.Data.ItemRoomDatabase
import com.example.a10wordapp.Data.Item

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
            addNewItem(id, english, japanese)
            finish()
        }

        binding.backButton.setOnClickListener{
            finish()
        }
    }

    private fun addNewItem(id: Int, english: String, japanese: String){
        viewModel.NewItem(this,
            id, english, japanese)
    }
}