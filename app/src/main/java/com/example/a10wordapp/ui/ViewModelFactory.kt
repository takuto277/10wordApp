package com.example.a10wordapp.ui

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a10wordapp.repository.DataRepository
import com.example.a10wordapp.repository.InitialDataRepository
import com.example.a10wordapp.repository.QuizRepository
import com.example.a10wordapp.ui.quizadd.QuizAddViewModel
import com.example.a10wordapp.ui.delete.DeleteViewModel
import com.example.a10wordapp.ui.home.HomeViewModel
import com.example.a10wordapp.ui.quiz.QuizViewModel
import com.example.a10wordapp.ui.quizlist.QuizListViewModel
import com.example.a10wordapp.ui.quizselect.QuizSelectViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(QuizViewModel::class.java) ->
                    QuizViewModel(DataRepository(context), QuizRepository())
                isAssignableFrom(QuizListViewModel::class.java) ->
                    QuizListViewModel(DataRepository(context))
                isAssignableFrom(DeleteViewModel::class.java) ->
                    DeleteViewModel(DataRepository(context))
                isAssignableFrom(QuizAddViewModel::class.java) ->
                    QuizAddViewModel(DataRepository(context))
                isAssignableFrom(HomeViewModel::class.java) ->
                    HomeViewModel(DataRepository(context), InitialDataRepository(context))
                isAssignableFrom(QuizSelectViewModel::class.java) ->
                    QuizSelectViewModel(DataRepository(context))
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
            INSTANCE
    }

    @VisibleForTesting
    fun destroyInstance() {
        INSTANCE = null
    }
}