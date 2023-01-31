package com.example.a10wordapp.ui.quizdelete.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.data.db.entity.InitialDataEntity
import com.example.a10wordapp.databinding.OneLayoutBinding

class RecyclerAdapter(private val InitialDataList: List<InitialDataEntity>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: OneLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val oneLayouts = InitialDataList[position]

                primaryText.text = oneLayouts.english
                secondaryText.text = oneLayouts.japanese
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val infater = LayoutInflater.from(parent.context)
        val binding = OneLayoutBinding.inflate(infater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    //６）データが何件あるかをカウントする
    override fun getItemCount(): Int {
        return InitialDataList.count()
    }
}