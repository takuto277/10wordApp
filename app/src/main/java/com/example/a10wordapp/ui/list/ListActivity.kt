package com.example.a10wordapp.ui.list

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListAdapter
import com.example.a10wordapp.R
import com.example.a10wordapp.databinding.ActivityListBinding
import android.widget.ListView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.a10wordapp.Data.Item
import com.example.a10wordapp.Data.ItemRoomDatabase
import kotlinx.coroutines.runBlocking

class
ListActivity : AppCompatActivity(){
    private val viewModel: ListViewModel by viewModels()
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = ListView(this)
        setContentView(listView)
        var array: Array<String> = arrayOf()
        val list = viewModel.getList(this)
        println("papa${list}")
        println("papa${list.count()}")
        for(i in 0 until list.count()){
            array += list[i].english
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,array)

        listView.adapter = adapter

        listView.setOnItemClickListener{ adapter, view, position, id ->
            val message = "「${(array[position])}」をクリックしました。"
            Toast.makeText(this@ListActivity, message, Toast.LENGTH_SHORT).show()
        }
    }
}