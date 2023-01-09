package com.example.a10wordapp.ui.add

import android.os.Bundle
import android.widget.Button
import com.example.a10wordapp.R
import com.example.a10wordapp.databinding.ActivityAddBinding
import com.example.a10wordapp.ui.base.BaseActivity

//import com.example.a10wordapp.ViewModel
//import androidx.activity.viewModels

class AddActivity : BaseActivity() {

  //  private val viewModel: ViewModel by viewModels()
    private lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


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
  //      viewModel.addNewItem(id, english, japanese)

    }

    override fun initViewBinding() {
        binding = ActivityAddBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}