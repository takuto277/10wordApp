package com.example.a10wordapp.ui.questionlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.R
import com.example.a10wordapp.domain.entity.QuestionListItem

class QuestionListAdapter(private val dataSet: Array<QuestionListItem>) :
    RecyclerView.Adapter<QuestionListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rootView: View
        val textView: TextView

        init {
            rootView = view.findViewById(R.id.root)
            textView = view.findViewById(R.id.textView)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: QuestionListItem)
    }

    var itemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.questionlist_row_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position].text
        viewHolder.rootView.setOnClickListener {
            itemClickListener?.onItemClick(dataSet[position])
        }
    }

    override fun getItemCount() = dataSet.size
}