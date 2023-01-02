//package com.example.a10wordapp.Data
//
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//import java.text.NumberFormat
//
//@Entity(tableName = "item_table")
//data class Item(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int = 0,
//    @ColumnInfo(name = "english")
//    val english: String,
//    @ColumnInfo(name = "japanese")
//    val japanese: String
//    )
//    /**
//     * Returns the passed in price in currency format.
//     */
////    fun Item.getFormattedPrice(): String =
////        NumberFormat.getCurrencyInstance().format(itemPrice)
////}