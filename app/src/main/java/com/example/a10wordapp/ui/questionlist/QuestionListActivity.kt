package com.example.a10wordapp.ui.questionlist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a10wordapp.ViewModelFactory
import com.example.a10wordapp.databinding.ActivityQuestionlistBinding
import com.example.a10wordapp.domain.entity.QuestionListItem
import com.example.a10wordapp.ui.questionlist.adapter.QuestionListAdapter

class QuestionListActivity : AppCompatActivity() {

    private val viewModel: QuestionListViewModel by viewModels { ViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQuestionlistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getListView(this)
        binding.mainList.also { listView ->
            val dummyItems = arrayOf(
                QuestionListItem("Axe"),
                QuestionListItem("Box")
            ) // TODO
            val adapter = QuestionListAdapter(dummyItems)
            listView.adapter = adapter
            listView.addItemDecoration(
                DividerItemDecoration(
                    this,
                    LinearLayoutManager(this).orientation
                )
            )
            adapter.itemClickListener = object : QuestionListAdapter.OnItemClickListener {
                override fun onItemClick(item: QuestionListItem) {
                    Toast.makeText(
                        this@QuestionListActivity,
                        "「${item.text}」をクリックしました。",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
//
//        val listView = viewModel.listViewLiveData.value ?: return
//        setContentView(listView)
//
//        // リストを取得する
//        viewModel.getList(this)
//
//        listView.setOnItemClickListener { adapter, view, position, id ->
//            val itemArray = viewModel.arrayLiveData.value ?: return@setOnItemClickListener
//            Toast.makeText(
//                this@QuestionListActivity,
//                "「${(itemArray[position])}」をクリックしました。",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//
//        viewModel.listLiveData.observe(this, Observer {
//            val itemList = viewModel.listLiveData.value ?: return@Observer
//            viewModel.getArrayList(itemList)
//        })
//
//        viewModel.arrayLiveData.observe(this, Observer {
//            val itemArray = viewModel.arrayLiveData.value ?: return@Observer
//            viewModel.getAdapter(listView, this, itemArray)
//        })
    }
}