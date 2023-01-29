package com.example.a10wordapp.repository

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.a10wordapp.api.InitialDataAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class InitialDataRepository(private val contect: Context) {

    suspend fun fetchInitialData(): String {
            try {
                val apiResponse = InitialDataAPI().service.fetchInitialData()

                Log.d("apiResponse", "$apiResponse")

                if (apiResponse != null) {
                    return apiResponse.data[0].english
                }
            } catch (e: Exception) {
                Log.d("response", "debug $e")
                return "失敗"
            }
        return "エラー"
    }
}