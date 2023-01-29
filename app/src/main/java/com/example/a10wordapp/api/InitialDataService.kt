package com.example.a10wordapp.api

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET

interface InitialDataService {
    @GET("takuto277/64a7ef7225cfb42e1bfa08d958fde985/raw/58f59951bc5b5fa11cb0dadb69ffb0949441e063/10words.json")
    suspend fun fetchInitialData(
    ): InitialDataResponse
}