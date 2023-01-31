package com.example.a10wordapp.repository

import android.content.Context
import com.example.a10wordapp.api.InitialDataAPI
import com.example.a10wordapp.api.InitialDataResponse

class InitialDataRepository(private val contect: Context) {

    suspend fun fetchInitialData(): InitialDataResponse {
        return InitialDataAPI().service.fetchInitialData()
    }
}