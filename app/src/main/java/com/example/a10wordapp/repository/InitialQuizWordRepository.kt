package com.example.a10wordapp.repository

import android.content.Context
import com.example.a10wordapp.data.api.InitialDataAPI
import com.example.a10wordapp.data.api.InitialDataResponse

interface InitialQuizWordRepository {
    suspend fun fetchInitialData(): InitialDataResponse
}

class InitialQuizWordRepositoryImpl(private val contect: Context): InitialQuizWordRepository {

    override suspend fun fetchInitialData(): InitialDataResponse {
        return InitialDataAPI().service.fetchInitialData()
    }
}