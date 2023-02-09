package com.example.a10wordapp.repository

import com.example.a10wordapp.data.api.InitialQuizDataAPI
import com.example.a10wordapp.data.api.InitialQuizDataResponse

interface InitialQuizWordRepository {
    suspend fun fetchInitialData(): InitialQuizDataResponse
}

class InitialQuizWordRepositoryImpl(
    private val initialQuizDataAPI: InitialQuizDataAPI
) : InitialQuizWordRepository {

    override suspend fun fetchInitialData(): InitialQuizDataResponse {
        return initialQuizDataAPI.service.fetchInitialData()
    }
}