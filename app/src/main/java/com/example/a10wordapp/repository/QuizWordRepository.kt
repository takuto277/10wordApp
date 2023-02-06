package com.example.a10wordapp.repository

import android.content.Context
import com.example.a10wordapp.data.AppRoomDatabase
import com.example.a10wordapp.data.api.Data
import com.example.a10wordapp.data.db.entity.InitialDataEntity
import com.example.a10wordapp.data.db.entity.ItemEntity
import com.example.a10wordapp.domain.entity.GetListEntity
import kotlinx.coroutines.runBlocking

interface QuizWordRepository {
    fun addNewItem(english: String, japanese: String)
    suspend fun saveInitialData(data: Array<Data>)
    suspend fun getList(planSwitch: Boolean): List<GetListEntity>
}

class QuizWordRepositoryImpl(private val context: Context) : QuizWordRepository {
    override fun addNewItem(english: String, japanese: String) {
        val getDatabase = AppRoomDatabase.getDatabase(context)
        val itemEntiry = ItemEntity(0, english, japanese)
        val itemDao = getDatabase.itemDao()
        runBlocking {
            itemDao.insert(itemEntiry)
        }
    }

    override suspend fun saveInitialData(data: Array<Data>) {
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

    override suspend fun getList(planSwitch: Boolean): List<GetListEntity> {
        val getDatabase = AppRoomDatabase.getDatabase(context)
        val initialDataDao = getDatabase.initialDataDao()
        val itemDao = getDatabase.itemDao()
        var list: List<GetListEntity>
        if (planSwitch) {
            list = initialDataDao.getAll().map { entity ->
                GetListEntity(
                    id = entity.id,
                    english = entity.english,
                    japanese = entity.japanese
                )
            }
        } else {
            list = itemDao.getAll().map { entity ->
                GetListEntity(
                    id = entity.id,
                    english = entity.english,
                    japanese = entity.japanese
                )
            }
        }
        return list
    }
}