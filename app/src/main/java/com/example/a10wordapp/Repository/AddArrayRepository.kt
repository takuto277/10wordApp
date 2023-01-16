package com.example.a10wordapp.Repository

import com.example.a10wordapp.Data.ItemEntiry

class AddArrayRepository() {
    fun addArray(list: List<ItemEntiry>?): Array<String> {
        var array: Array<String> = arrayOf()
        for (i in 0 until list!!.count()) {
            array += list[i].english
        }
        return array
    }
}