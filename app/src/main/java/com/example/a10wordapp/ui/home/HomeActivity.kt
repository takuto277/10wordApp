package com.example.a10wordapp.ui.home


import android.os.Bundle
import android.content.Intent
import com.example.a10wordapp.databinding.ActivityHomeBinding
import com.example.a10wordapp.ui.ForthActivity
import com.example.a10wordapp.ui.quiz.QuizActivity
import com.example.a10wordapp.ui.ThirdActivity
import com.example.a10wordapp.ui.base.BaseActivity

class HomeActivity : BaseActivity(){
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.learnButton.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
        binding.addButton.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
        binding.allButton.setOnClickListener {
            val intent = Intent(this, ForthActivity::class.java)
            startActivity(intent)
        }
    }

    override fun initViewBinding() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}