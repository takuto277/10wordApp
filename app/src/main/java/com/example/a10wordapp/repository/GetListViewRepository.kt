package com.example.a10wordapp.repository

import android.R
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.ListView

class GetListViewRepository {
    fun getListView(context: Context): ListView {
        return ListView(context)
    }

    fun getAdapter(context: Context, array: Array<String>): ArrayAdapter<String> {
        return ArrayAdapter(context, R.layout.simple_list_item_1, array)
    }
}