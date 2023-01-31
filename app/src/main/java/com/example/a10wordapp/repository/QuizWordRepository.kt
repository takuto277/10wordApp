package com.example.a10wordapp.repository

import android.content.Context
import com.example.a10wordapp.data.api.Data
import com.example.a10wordapp.data.AppRoomDatabase
import com.example.a10wordapp.data.db.entity.InitialDataEntity
import com.example.a10wordapp.data.db.entity.ItemEntity
import kotlinx.coroutines.runBlocking

class QuizWordRepository(private val context: Context) {
    fun addNewItem(id: Int, english: String, japanese: String) {
        val getDatabase = AppRoomDatabase.getDatabase(context)
        val itemEntiry = ItemEntity(id, english, japanese)
        val itemDao = getDatabase.itemDao()
        runBlocking {
            itemDao.insert(itemEntiry)
        }

        var list: List<ItemEntity>
        runBlocking {
            list = itemDao.getAll()
        }
    }

    suspend fun saveInitialData(data: Array<Data>) {
        val getDatabase = AppRoomDatabase.getDatabase(context)
        val initialDataDao = getDatabase.initialDataDao()
        if (initialDataDao.getAll().isNotEmpty()) {
            initialDataDao.deleteAll()
        }
        data.forEach {
            val initialDataEntity = InitialDataEntity(it.ID, it.english, it.japanese)
            runBlocking {
                initialDataDao.insert(initialDataEntity)
            }
        }
    }

    fun getList(): List<ItemEntity> {
        val getDatabase = AppRoomDatabase.getDatabase(context)
        val itemDao = getDatabase.itemDao()

        var list: List<ItemEntity>
        runBlocking {
            list = itemDao.getAll()
        }
        return list
    }

    fun getInitialDataList(): List<InitialDataEntity> {
        val getDatabase = AppRoomDatabase.getDatabase(context)
        val initialDataDao = getDatabase.initialDataDao()

        var list: List<InitialDataEntity>
        runBlocking {
            list = initialDataDao.getAll()
        }
        return list
    }
}