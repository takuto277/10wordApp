package com.example.a10wordapp.ui.list

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class ListActivity : AppCompatActivity() {
    private val viewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getListView(this)
        val listView = viewModel.listViewLiveData.value ?: return
        setContentView(listView)

         // リストを取得する
        viewModel.getList(this)

        listView.setOnItemClickListener { adapter, view, position, id ->
            val itemArray = viewModel.arrayLiveData.value ?: return@setOnItemClickListener
            Toast.makeText(
                this@ListActivity,
                "「${(itemArray[position])}」をクリックしました。",
                Toast.LENGTH_SHORT
            ).show()
        }
        viewModel.listLiveData.observe(this, Observer {
            val itemList = viewModel.listLiveData.value ?: return@Observer
            viewModel.getArrayList(itemList)
        })

        viewModel.arrayLiveData.observe(this, Observer {
            val itemArray = viewModel.arrayLiveData.value ?: return@Observer
            viewModel.getAdapter(listView, this, itemArray)
        })
    }
}