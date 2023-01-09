package com.example.a10wordapp.ui.list

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import com.example.a10wordapp.R
import com.example.a10wordapp.databinding.ActivityListBinding
import com.example.a10wordapp.ui.base.BaseActivity
import android.widget.ListView
import android.widget.Toast

class ListActivity : BaseActivity(){
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val array = arrayOf("リスト1", "リスト2", "リスト3")
        val listView = ListView(this)
        setContentView(listView)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,array)

        listView.adapter = adapter

        listView.setOnItemClickListener{ adapter, view, position, id ->
            val message = "「${(array[position])}」をクリックしました。"
            Toast.makeText(this@ListActivity, message, Toast.LENGTH_SHORT).show()
        }

        binding.btnBack.setOnClickListener{
            finish()
        }
    }

    override fun initViewBinding() {
        // TODO: ListViewにはbindingが使えない→ボタンの配置ができない
        binding = ActivityListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}