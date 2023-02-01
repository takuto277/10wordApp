package com.example.a10wordapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.a10wordapp.databinding.ActivityHomeBinding
import com.example.a10wordapp.ui.ViewModelFactory
import com.example.a10wordapp.ui.quizadd.QuizAddActivity
import com.example.a10wordapp.ui.quizdelete.QuizDeleteActivity
import com.example.a10wordapp.ui.quizlist.QuizListActivity
import com.example.a10wordapp.ui.quizselect.QuizSelectActivity



class HomeActivity : AppCompatActivity() {
    private val viewModel: HomeViewModelImpl by viewModels { ViewModelFactory(applicationContext) }
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.learnButton.setOnClickListener {
            val intent = Intent(this, QuizSelectActivity::class.java)
            startActivity(intent)
        }
        binding.addButton.setOnClickListener {
            val intent = Intent(this, QuizAddActivity::class.java)
            startActivity(intent)
        }
        binding.deleteButton.setOnClickListener {
            val intent = Intent(this, QuizDeleteActivity::class.java)
            startActivity(intent)
        }
        binding.allButton.setOnClickListener {
            val intent = Intent(this, QuizListActivity::class.java)
            startActivity(intent)
        }
        binding.apiFetchButton.setOnClickListener {
            viewModel.fetchAPI()
        }

        viewModel.english.observe(this, Observer { english ->
            Toast.makeText(
                this@HomeActivity,
                "「${english}」を表示します。",
                Toast.LENGTH_SHORT
            ).show()
        })
    }
}
