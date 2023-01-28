package com.example.a10wordapp.ui.home


import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Query
import com.example.a10wordapp.api.InitialDataResponse
import com.example.a10wordapp.api.InitialDataService
import com.example.a10wordapp.databinding.ActivityHomeBinding
import com.example.a10wordapp.ui.quizlist.QuizListActivity
import com.example.a10wordapp.ui.add.AddActivity
import com.example.a10wordapp.ui.delete.DeleteActivity
import com.example.a10wordapp.ui.quizselect.QuizSelectActivity
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import kotlin.concurrent.thread


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.learnButton.setOnClickListener {
            val intent = Intent(this, QuizSelectActivity::class.java)
            startActivity(intent)
        }
        binding.addButton.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
        binding.deleteButton.setOnClickListener {
            val intent = Intent(this, DeleteActivity::class.java)
            startActivity(intent)
        }
        binding.allButton.setOnClickListener {
            val intent = Intent(this, QuizListActivity::class.java)
            startActivity(intent)
        }
        binding.apiFetchButton.setOnClickListener {
            fetchApi()
        }
     }
    private fun fetchApi() {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        thread {
            try {
                val service: InitialDataService = retrofit.create(InitialDataService::class.java)
                val apiResponse = service.fetchInitialData().execute().body()

                Handler(Looper.getMainLooper()).post {
                    if (apiResponse != null) {
                        Toast.makeText(
                            this@HomeActivity,
                            "「${apiResponse.data[0].ID}」をクリックしました。",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } catch (e: Exception) {
                Log.d("response", "debug $e")
            }
        }
    }
}