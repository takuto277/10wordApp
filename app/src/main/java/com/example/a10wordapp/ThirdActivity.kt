package com.example.a10wordapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.a10wordapp.databinding.ActivitySecondBinding
import com.example.a10wordapp.databinding.ActivityThirdBinding
//import com.example.a10wordapp.ViewModel
//import androidx.activity.viewModels

class ThirdActivity : AppCompatActivity() {

  //  private val viewModel: ViewModel by viewModels()
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val btnBack: Button = findViewById(R.id.btnBack)

        binding = ActivityThirdBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)

        binding.saveAction.setOnClickListener {
            addNewItem(1, "aa", "bb")
        }

        binding.buckAction.setOnClickListener {
            finish()
        }
    }

    private fun addNewItem(id: Int, english: String, japanese: String){
  //      viewModel.addNewItem(id, english, japanese)

    }
}