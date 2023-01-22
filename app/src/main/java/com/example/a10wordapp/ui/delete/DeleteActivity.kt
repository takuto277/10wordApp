package com.example.a10wordapp.ui.delete

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.ViewModelFactory
import com.example.a10wordapp.data.ItemEntiry
import com.example.a10wordapp.databinding.ActivityDeleteBinding
import com.example.a10wordapp.ui.delete.adapter.RecyclerAdapter
import com.example.a10wordapp.ui.delete.adapter.TestList

class DeleteActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityDeleteBinding
    private val viewModel:DeleteViewModel by viewModels{ViewModelFactory(applicationContext)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getList(this)
        val itemList = viewModel.list.value ?: return

        binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)

        val rLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        recyclerView.adapter = RecyclerAdapter(itemList)
    }
}