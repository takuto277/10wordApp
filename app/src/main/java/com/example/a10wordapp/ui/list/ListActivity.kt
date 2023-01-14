package com.example.a10wordapp.ui.list

import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.a10wordapp.databinding.ActivityListBinding
import android.widget.ListView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class
ListActivity : AppCompatActivity(){
    private val viewModel: ListViewModel by viewModels()
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listView: ListView = viewModel.getListView(this)
        setContentView(listView)

        var array: Array<String> = arrayOf()
        val list = viewModel.getList(this)
        for(i in 0 until list.count()){
            array += list[i].english
        }
        viewModel.getAdapter(listView, this, array)

        listView.setOnItemClickListener{ adapter, view, position, id ->
            val message = "「${(array[position])}」をクリックしました。"
            Toast.makeText(this@ListActivity, message, Toast.LENGTH_SHORT).show()
        }
    }
}