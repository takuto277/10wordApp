package com.example.a10wordapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val learnButton: Button = findViewById(R.id.learnButton)
        val addButton: Button = findViewById(R.id.addButton)
        val allButton: Button = findViewById(R.id.allButton)

        learnButton.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        addButton.setOnClickListener {
            val intent = Intent(this,ThirdActivity::class.java)
            startActivity(intent)
        }
        allButton.setOnClickListener {
            val intent = Intent(this,ForthActivity::class.java)
            startActivity(intent)
        }
    }
}