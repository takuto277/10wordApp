package com.example.a10wordapp.api

data class InitialDataResponse(
    val data: Array<Data>
)

data class Data(
    val ID: Int,
    val english: String,
    val japanese: String
)