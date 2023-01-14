package com.example.a10wordapp.ui.list

import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class
ListActivity : AppCompatActivity(){
    private val viewModel: ListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listView: ListView = viewModel.getListView(this)
        setContentView(listView)

        val list = viewModel.getList(this)

        var array: Array<String> = viewModel.getArrayList(list)

        viewModel.getAdapter(listView, this, array)

        listView.setOnItemClickListener{ adapter, view, position, id ->
            val message = "「${(array[position])}」をクリックしました。"
            Toast.makeText(this@ListActivity, message, Toast.LENGTH_SHORT).show()
        }
    }
}