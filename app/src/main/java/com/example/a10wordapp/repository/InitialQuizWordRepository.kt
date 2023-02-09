package com.example.a10wordapp.repository

import com.example.a10wordapp.data.api.InitialQuizAPI
import com.example.a10wordapp.data.api.InitialQuizResponse

interface InitialQuizWordRepository {
    suspend fun fetchInitialData(): InitialQuizResponse
}

class InitialQuizWordRepositoryImpl(
    private val initialQuizAPI: InitialQuizAPI
) : InitialQuizWordRepository {

    override suspend fun fetchInitialData(): InitialQuizResponse {
        return initialQuizAPI.service.fetchInitialData()
    }
}