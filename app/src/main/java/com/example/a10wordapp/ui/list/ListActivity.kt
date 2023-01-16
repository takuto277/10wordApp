package com.example.a10wordapp.ui.list

import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.a10wordapp.Data.ItemEntiry
import com.google.android.material.snackbar.Snackbar

class
ListActivity : AppCompatActivity(){
    private val viewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listView: ListView = viewModel.getListView(this)
        setContentView(listView)

        var list = viewModel.listLiveData

        viewModel.getList(this)

        var notLiveDataList = viewModel.listLiveData.value

        var array: Array<String> = viewModel.getArrayList(notLiveDataList)

        viewModel.getAdapter(listView, this, array)

        listView.setOnItemClickListener{ adapter, view, position, id ->
            val message = "「${(array[position])}」をクリックしました。"
            Toast.makeText(this@ListActivity, message, Toast.LENGTH_SHORT).show()
        }

        viewModel.listLiveData.observe(this, Observer {
            Snackbar.make(listView, "ListLiveDataです", Snackbar.LENGTH_LONG).show()
        })
    }
}