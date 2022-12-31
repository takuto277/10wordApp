package com.example.a10wordapp

import androidx.room.Entity
import androidx.room.ColumnInfo
import  androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class User {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    @ColumnInfo(englishWord = "englishWord")
    var englishWord: String = ""

    @ColumnInfo(translationWord = "translationWord")
    var englishWord: String = ""
}