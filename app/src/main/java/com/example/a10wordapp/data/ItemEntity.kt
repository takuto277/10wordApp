package com.example.a10wordapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "english")
    val english: String,
    @ColumnInfo(name = "japanese")
    val japanese: String
)