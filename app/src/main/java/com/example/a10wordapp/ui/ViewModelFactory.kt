package com.example.a10wordapp.ui

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a10wordapp.data.api.InitialDataAPIImpl
import com.example.a10wordapp.repository.InitialQuizWordRepositoryImpl
import com.example.a10wordapp.repository.QuizWordRepositoryImpl
import com.example.a10wordapp.ui.home.HomeViewModel
import com.example.a10wordapp.ui.main.MainViewModel
import com.example.a10wordapp.ui.quizadd.QuizAddViewModel
import com.example.a10wordapp.ui.quizdelete.QuizDeleteViewModel
import com.example.a10wordapp.ui.quizlist.QuizListViewModel
import com.example.a10wordapp.ui.quizselect.QuizSelectViewModel
import com.example.a10wordapp.ui.quizshow.QuizShowViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(QuizShowViewModel::class.java) ->
                    QuizShowViewModel(QuizWordRepositoryImpl(context))
                isAssignableFrom(QuizListViewModel::class.java) ->
                    QuizListViewModel(QuizWordRepositoryImpl(context))
                isAssignableFrom(QuizDeleteViewModel::class.java) ->
                    QuizDeleteViewModel(QuizWordRepositoryImpl(context))
                isAssignableFrom(QuizAddViewModel::class.java) ->
                    QuizAddViewModel(QuizWordRepositoryImpl(context))
                isAssignableFrom(HomeViewModel::class.java) ->
                    HomeViewModel(
                        QuizWordRepositoryImpl(context),
                        InitialQuizWordRepositoryImpl(context, InitialDataAPIImpl())
                    )
                isAssignableFrom(QuizSelectViewModel::class.java) ->
                    QuizSelectViewModel(QuizWordRepositoryImpl(context))
                isAssignableFrom(MainViewModel::class.java) ->
                    MainViewModel(QuizWordRepositoryImpl(context))
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