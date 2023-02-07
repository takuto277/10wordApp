package com.example.a10wordapp.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

interface InitialQuizDataAPI {
    val service: InitialQuizDataService
}

class InitialQuizDataAPIImpl : InitialQuizDataAPI {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/")
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
            )
        )
        .build()

    override val service: InitialQuizDataService =
        retrofit.create(InitialQuizDataService::class.java)
}