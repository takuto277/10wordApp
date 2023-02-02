package com.example.a10wordapp.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface InitialDataAPI {
    val moshi: Moshi
    val retrofit: Retrofit
    val service: InitialDataService
}

class InitialDataAPIImpl: InitialDataAPI {
    override val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    override val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    override val service: InitialDataService = retrofit.create(InitialDataService::class.java)
}