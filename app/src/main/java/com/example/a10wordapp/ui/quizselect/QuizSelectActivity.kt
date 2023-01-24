package com.example.a10wordapp.ui.quizselect

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.ViewModelFactory
import com.example.a10wordapp.databinding.ActivityQuizSelectBinding
import com.example.a10wordapp.domain.entity.QuizSelectItem
import com.example.a10wordapp.ui.quizselect.adapter.QuizSelectAdapter

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
        val quizSelectAdapter = QuizSelectAdapter(dataSet)
        quizSelectAdapter.itemClickListener = object : QuizSelectAdapter.onItemClickListener {
            override fun onItemClick(item: QuizSelectItem) {
                Toast.makeText(this@QuizSelectActivity,
                    "「${item.text}」をクリックしました。",
                Toast.LENGTH_SHORT).show()
            }
        }
        recyclerView.apply {
            adapter = quizSelectAdapter
        }
    }
}