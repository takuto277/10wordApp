package com.example.a10wordapp.data.api

data class InitialQuizDataResponse(
    val data: Array<Data>
)

data class Data(
    val ID: Int,
    val english: String,
    val japanese: String
)