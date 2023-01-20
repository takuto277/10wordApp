package com.example.a10wordapp.ui.delete

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.ViewModelFactory
import com.example.a10wordapp.databinding.ActivityDeleteBinding
import com.example.a10wordapp.ui.delete.adapter.RecyclerAdapter
import com.example.a10wordapp.ui.delete.adapter.TestList

class DeleteActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityDeleteBinding
    private val viewMode:DeleteViewModel by viewModels{ViewModelFactory()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)

        val rLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = rLayoutManager
        val data: List<TestList> = List(20) { TestList()}
        recyclerView.adapter = RecyclerAdapter(data)
    }
}