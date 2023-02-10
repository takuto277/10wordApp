package com.example.a10wordapp.repository

import android.content.Context
import com.example.a10wordapp.data.api.InitialQuiz
import com.example.a10wordapp.data.db.AppRoomDatabase
import com.example.a10wordapp.data.db.entity.InitialQuizEntity
import com.example.a10wordapp.data.db.entity.UserEditQuizEntity
import com.example.a10wordapp.domain.item.QuizItem

interface QuizWordRepository {
    suspend fun addNewItem(english: String, japanese: String)
    suspend fun saveInitialData(data: List<InitialQuiz>)
    suspend fun getQuizList(planSwitch: Boolean): List<QuizItem>
}

class QuizWordRepositoryImpl(private val context: Context) : QuizWordRepository {
    override suspend fun addNewItem(english: String, japanese: String) {
        val getDatabase = AppRoomDatabase.getDatabase(context)
        val itemEntiry = UserEditQuizEntity(0, english, japanese)
        val itemDao = getDatabase.userEditQuizDataDao()
        itemDao.insert(itemEntiry)
    }

    override suspend fun saveInitialData(data: List<InitialQuiz>) {
        val getDatabase = AppRoomDatabase.getDatabase(context)
        val initialDataDao = getDatabase.initialQuizDataDao()
        if (initialDataDao.getAll().isNotEmpty()) {
            initialDataDao.deleteAll()
        }
        data.forEach {
            val initialQuizEntity = InitialQuizEntity(it.id, it.english, it.japanese)
            initialDataDao.insert(initialQuizEntity)
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