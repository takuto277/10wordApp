package com.example.a10wordapp.ui.delete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.databinding.ActivityDeleteBinding
import com.example.a10wordapp.ui.base.BaseActivity
import com.example.a10wordapp.ui.delete.adapter.Adapter

class DeleteActivity : BaseActivity() {
    private lateinit var binding: ActivityDeleteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)

        val rLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = rLayoutManager

        recyclerView.adapter = Adapter()
    }

    override fun initViewBinding() {
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}