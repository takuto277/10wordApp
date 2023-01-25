package com.example.a10wordapp.ui.quizselect

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.ViewModelFactory
import com.example.a10wordapp.databinding.ActivityQuizSelectBinding
import com.example.a10wordapp.domain.entity.QuizSelectItem
import com.example.a10wordapp.ui.quiz.QuizActivity
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
                val intent = Intent(this@QuizSelectActivity, QuizActivity::class.java)
                intent.putExtra("Item", item.text)
                startActivity(intent)
            }
        }
        recyclerView.layoutManager = GridLayoutManager(this,3)
        recyclerView.apply {
            adapter = quizSelectAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@QuizSelectActivity,
                    GridLayoutManager(this@QuizSelectActivity, 3).orientation,

                )
            )
        }
    }
}