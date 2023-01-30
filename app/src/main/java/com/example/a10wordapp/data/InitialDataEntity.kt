package com.example.a10wordapp.data

import androidx.room.PrimaryKey
import androidx.room.Entity
import androidx.room.ColumnInfo

@Entity
data class InitialDataEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "english")
    val english: String,
    @ColumnInfo(name = "japanese")
    val japanese: String

)