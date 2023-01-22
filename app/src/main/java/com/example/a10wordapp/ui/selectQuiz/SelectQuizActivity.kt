package com.example.a10wordapp.ui.selectQuiz

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.a10wordapp.databinding.ActivitySelectquizBinding

class SelectQuizActivity: AppCompatActivity() {

    val one = arrayOf("one", "two", "three", "four")
    val two = arrayOf("one", "two", "three", "four")
    val data = arrayOf(one, two)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            val tableLayout = TableLayout(this).also {

                for(figure in data) {
                val table = TableRow(this).also {
                    for(figure in figure) {
                        val button = Button(this)
                        button.text = figure
                        it.addView(button)
                    }
                }
                    it.addView(table)
            }
        }
        setContentView(tableLayout)

        tableLayout.setOnClickListener {
            Toast.makeText(
                this,
                "「」をクリックしました。",
                Toast.LENGTH_SHORT
            ).show()

        }

        }
    }