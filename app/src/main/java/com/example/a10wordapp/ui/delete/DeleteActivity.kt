package com.example.a10wordapp.ui.delete

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.databinding.ActivityDeleteBinding
import com.example.a10wordapp.ui.base.BaseActivity
import com.example.a10wordapp.ui.delete.adapter.RecyclerAdapter
import com.example.a10wordapp.ui.delete.adapter.TestList

class DeleteActivity : BaseActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityDeleteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)

        val rLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = rLayoutManager
        val data: List<TestList> = List(20) { TestList()}
        recyclerView.adapter = RecyclerAdapter(data)
    }

    override fun initViewBinding() {
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}