package com.example.a10wordapp.ui.list

import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar

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
            viewModel.hoge()
        }

        viewModel.liveData.observe(this, Observer {
            Snackbar.make(listView, "押されたよ", Snackbar.LENGTH_LONG).show()
        })
        viewModel.listLiveData.observe(this, Observer {
            Snackbar.make(listView, "ListLiveDataです", Snackbar.LENGTH_LONG).show()
        })
    }
}