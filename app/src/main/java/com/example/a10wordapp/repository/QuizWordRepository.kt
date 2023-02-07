package com.example.a10wordapp.repository

import android.content.Context
import com.example.a10wordapp.data.AppRoomDatabase
import com.example.a10wordapp.data.api.Data
import com.example.a10wordapp.data.db.entity.InitialQuizDataEntity
import com.example.a10wordapp.data.db.entity.UserEditQuizDataEntity
import com.example.a10wordapp.domain.item.QuizItem
import kotlinx.coroutines.runBlocking

interface QuizWordRepository {
    fun addNewItem(english: String, japanese: String)
    suspend fun saveInitialData(data: Array<Data>)
    suspend fun getQuizList(planSwitch: Boolean): List<QuizItem>
}

class QuizWordRepositoryImpl(private val context: Context) : QuizWordRepository {
    override fun addNewItem(english: String, japanese: String) {
        val getDatabase = AppRoomDatabase.getDatabase(context)
        val itemEntiry = UserEditQuizDataEntity(0, english, japanese)
        val itemDao = getDatabase.userEditQuizDataDao()
        //TODO: suspendに置き換え
        runBlocking {
            itemDao.insert(itemEntiry)
        }
    }

    override suspend fun saveInitialData(data: Array<Data>) {
        val getDatabase = AppRoomDatabase.getDatabase(context)
        val initialDataDao = getDatabase.initialQuizDataDao()
        if (initialDataDao.getAll().isNotEmpty()) {
            initialDataDao.deleteAll()
        }
        data.forEach {
            val initialQuizDataEntity = InitialQuizDataEntity(it.ID, it.english, it.japanese)
            //TODO: suspendに置き換え
            runBlocking {
                initialDataDao.insert(initialQuizDataEntity)
            }
        }
    }

    private suspend fun fetchInitialQuizValues(): List<QuizItem> {
        val dao = AppRoomDatabase.getDatabase(context).initialQuizDataDao()
        return dao.getAll().map { entity ->
            QuizItem(
                id = entity.id,
                english = entity.english,
                japanese = entity.japanese
            )
        }
    }

    private suspend fun fetchUserEditQuizValues(): List<QuizItem> {
        val dao = AppRoomDatabase.getDatabase(context).userEditQuizDataDao()
        return dao.getAll().map { entity ->
            QuizItem(
                id = entity.id,
                english = entity.english,
                japanese = entity.japanese
            )
        }
    }

    override suspend fun getQuizList(planSwitch: Boolean): List<QuizItem> {
        return when (planSwitch) {
            true -> fetchInitialQuizValues()
            false -> fetchUserEditQuizValues()
        }
    }
}