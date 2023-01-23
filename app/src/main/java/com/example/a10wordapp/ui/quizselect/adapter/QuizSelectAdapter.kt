package com.example.a10wordapp.ui.quizselect.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.R
import com.example.a10wordapp.domain.entity.QuizSelectItem

class QuizSelectAdapter(
    private val dataSet: Array<QuizSelectItem>
    ) : RecyclerView.Adapter<QuizSelectAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val rootView: View
            val textView: TextView

            init {
                rootView = view.findViewById(R.id.root)
                textView = view.findViewById(R.id.textView)
            }
        }
    }
