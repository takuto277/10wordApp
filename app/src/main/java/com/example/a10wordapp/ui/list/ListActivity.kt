package com.example.a10wordapp.ui.list

import android.os.Bundle
import android.widget.Button
import com.example.a10wordapp.R
import com.example.a10wordapp.databinding.ActivityListBinding
import com.example.a10wordapp.ui.base.BaseActivity

class ListActivity : BaseActivity(){
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val btnBack: Button = findViewById(R.id.btnBack)

        btnBack.setOnClickListener{
            finish()
        }
    }

    override fun initViewBinding() {
        binding = ActivityListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}