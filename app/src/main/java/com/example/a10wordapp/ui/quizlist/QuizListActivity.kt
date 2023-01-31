package com.example.a10wordapp.ui.quizlist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.databinding.ActivityQuizlistBinding
import com.example.a10wordapp.domain.entity.QuizListItem
import com.example.a10wordapp.ui.ViewModelFactory
import com.example.a10wordapp.ui.quizlist.adapter.QuizListAdapter

class QuizListActivity : AppCompatActivity() {

    private val viewModel: QuizListViewModel by viewModels { ViewModelFactory(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQuizlistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.quizListItem.observe(this) { listItems ->
            initListAdapter(binding.mainList, listItems)
        }
        viewModel.fetchContent()
    }

    private fun initListAdapter(recyclerView: RecyclerView, dataSet: Array<QuizListItem>) {
        val quizListAdapter = QuizListAdapter(dataSet)
        quizListAdapter.itemClickListener = object : QuizListAdapter.OnItemClickListener {
            override fun onItemClick(item: QuizListItem) {
                Toast.makeText(
                    this@QuizListActivity,
                    "「${item.text}」をクリックしました。",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        recyclerView.apply {
            adapter = quizListAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@QuizListActivity,
                    LinearLayoutManager(this@QuizListActivity).orientation
                )
            )
        }
    }
}