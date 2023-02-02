package com.example.a10wordapp.repository

import android.content.Context
import com.example.a10wordapp.data.api.InitialDataAPI
import com.example.a10wordapp.data.api.InitialDataAPIImpl
import com.example.a10wordapp.data.api.InitialDataResponse

interface InitialQuizWordRepository {
    suspend fun fetchInitialData(): InitialDataResponse
}

class InitialQuizWordRepositoryImpl(
    private val contect: Context,
    private val initialDataAPI: InitialDataAPI
    ): InitialQuizWordRepository {

    override suspend fun fetchInitialData(): InitialDataResponse {
        return initialDataAPI.service.fetchInitialData()
    }
}