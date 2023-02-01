package com.example.a10wordapp.ui

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a10wordapp.repository.QuizWordRepository
import com.example.a10wordapp.repository.InitialQuizWordRepository
import com.example.a10wordapp.ui.quizadd.QuizAddViewModel
import com.example.a10wordapp.ui.quizdelete.QuizDeleteViewModel
import com.example.a10wordapp.ui.home.HomeViewModel
import com.example.a10wordapp.ui.home.HomeViewModelImpl
import com.example.a10wordapp.ui.quizshow.QuizShowViewModel
import com.example.a10wordapp.ui.quizlist.QuizListViewModel
import com.example.a10wordapp.ui.quizselect.QuizSelectViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(QuizShowViewModel::class.java) ->
                    QuizShowViewModel(QuizWordRepository(context))
                isAssignableFrom(QuizListViewModel::class.java) ->
                    QuizListViewModel(QuizWordRepository(context))
                isAssignableFrom(QuizDeleteViewModel::class.java) ->
                    QuizDeleteViewModel(QuizWordRepository(context))
                isAssignableFrom(QuizAddViewModel::class.java) ->
                    QuizAddViewModel(QuizWordRepository(context))
                isAssignableFrom(HomeViewModelImpl::class.java) ->
                    HomeViewModelImpl(QuizWordRepository(context), InitialQuizWordRepository(context))
                isAssignableFrom(QuizSelectViewModel::class.java) ->
                    QuizSelectViewModel(QuizWordRepository(context))
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