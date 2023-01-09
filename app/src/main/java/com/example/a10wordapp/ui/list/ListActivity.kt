package com.example.a10wordapp.ui.list

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import com.example.a10wordapp.R
import com.example.a10wordapp.databinding.ActivityListBinding
import com.example.a10wordapp.ui.base.BaseActivity
import android.widget.ListView

class ListActivity : BaseActivity(){
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val array = arrayOf("リスト1", "リスト2", "リスト3")
        val listView = ListView(this)
        setContentView(listView)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,array)

        listView.adapter = adapter

        binding.btnBack.setOnClickListener{
            finish()
        }
    }

    override fun initViewBinding() {
        binding = ActivityListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}