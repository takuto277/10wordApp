package com.example.a10wordapp.data.api

import retrofit2.http.GET

interface InitialQuizDataService {
    @GET("takuto277/64a7ef7225cfb42e1bfa08d958fde985/raw/0e6ae79158f8b588f7bd60ced0747db3f90d8ef0/10words.json")
    suspend fun fetchInitialData(
    ): InitialQuizDataResponse
}