package com.example.a10wordapp.repository

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.a10wordapp.api.InitialDataAPI
import com.example.a10wordapp.api.InitialDataResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class InitialDataRepository(private val contect: Context) {

    suspend fun fetchInitialData(): InitialDataResponse {
                return InitialDataAPI().service.fetchInitialData()
    }
}