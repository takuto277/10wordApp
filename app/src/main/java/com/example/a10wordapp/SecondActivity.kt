package com.example.a10wordapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val btnBack: Button = findViewById(R.id.btnBack)

        btnBack.setOnClickListener{
            finish()
        }
    }
}
