package com.example.a10wordapp.repository

import com.example.a10wordapp.data.db.entity.ItemEntity

class AddArrayRepository() {
    fun addArray(list: List<ItemEntity>): Array<String> {
        var array: Array<String> = arrayOf()
        for (i in 0 until list.count()) {
            array += list[i].english
        }
        return array
    }
}