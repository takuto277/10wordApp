package com.example.a10wordapp.ui.quizselect

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.ViewModelFactory
import com.example.a10wordapp.databinding.ActivityQuizSelectBinding
import com.example.a10wordapp.domain.entity.QuizSelectItem

class QuizSelectActivity: AppCompatActivity() {
    private val viewModel: QuizSelectViewModel by viewModels {ViewModelFactory(applicationContext)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQuizSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.quizSelectItem.observe(this) { listItems ->
            initListAdapter(binding.recyclerView, listItems)
        }
        viewModel.fecthContent()
    }

    private fun initListAdapter(recyclerView: RecyclerView, dataSet: Array<QuizSelectItem>) {

    }
}