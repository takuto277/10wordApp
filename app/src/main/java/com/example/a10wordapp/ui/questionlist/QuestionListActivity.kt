package com.example.a10wordapp.ui.questionlist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.ViewModelFactory
import com.example.a10wordapp.databinding.ActivityQuestionlistBinding
import com.example.a10wordapp.domain.entity.QuestionListItem
import com.example.a10wordapp.ui.questionlist.adapter.QuestionListAdapter

class QuestionListActivity : AppCompatActivity() {

    private val viewModel: QuestionListViewModel by viewModels { ViewModelFactory(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQuestionlistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.questionListItem.observe(this) { listItems ->
            initListAdapter(binding.mainList, listItems)
        }
        viewModel.fetchContent()
    }

    private fun initListAdapter(recyclerView: RecyclerView, dataSet: Array<QuestionListItem>) {
        val questionListAdapter = QuestionListAdapter(dataSet)
        questionListAdapter.itemClickListener = object : QuestionListAdapter.OnItemClickListener {
            override fun onItemClick(item: QuestionListItem) {
                Toast.makeText(
                    this@QuestionListActivity,
                    "「${item.text}」をクリックしました。",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        recyclerView.apply {
            adapter = questionListAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@QuestionListActivity,

                    LinearLayoutManager(this@QuestionListActivity).orientation
                )
            )
        }
    }

}