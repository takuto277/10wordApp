package com.example.a10wordapp.repository

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.a10wordapp.api.InitialDataAPI

class InitialDataRepository(private val contect: Context) {

    fun fetchInitialData(): String {
        var string = ""
        Thread {
            try {
                val apiResponse = InitialDataAPI().service.fetchInitialData().execute().body()
                Log.d("apiResponse", "$apiResponse")

                if (apiResponse != null) {
                    string =apiResponse.data[0].english
                }
            } catch (e: Exception) {
                Log.d("response", "debug $e")
                string = "失敗"
            }
            string = ""
        }
        return string
    }

}