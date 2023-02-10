package com.example.a10wordapp.data.api

data class InitialQuizResponse(
    val data: List<InitialQuiz>
)

data class InitialQuiz(
    val id: Int,
    val english: String,
    val japanese: String
)