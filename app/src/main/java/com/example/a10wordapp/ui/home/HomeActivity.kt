package com.example.a10wordapp.ui.home


import android.os.Bundle
import android.content.Intent
import com.example.a10wordapp.databinding.ActivityHomeBinding
import com.example.a10wordapp.ui.list.ListActivity
import com.example.a10wordapp.ui.quiz.QuizActivity
import com.example.a10wordapp.ui.add.AddActivity
import com.example.a10wordapp.ui.base.BaseActivity
import com.example.a10wordapp.ui.delete.DeleteActivity

class HomeActivity : BaseActivity(){
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.learnButton.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
        binding.addButton.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
        binding.deleteButton.setOnClickListener {
            val intent = Intent(this, DeleteActivity::class.java)
            startActivity(intent)
        }
        binding.allButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }

    override fun initViewBinding() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}