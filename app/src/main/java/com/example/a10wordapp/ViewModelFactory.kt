package com.example.a10wordapp

import android.annotation.SuppressLint
import android.app.Application
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a10wordapp.repository.AddArrayRepository
import com.example.a10wordapp.repository.DataRepository
import com.example.a10wordapp.repository.GetListViewRepository
import com.example.a10wordapp.repository.QuizRepository
import com.example.a10wordapp.ui.add.AddViewModel
import com.example.a10wordapp.ui.delete.DeleteActivity
import com.example.a10wordapp.ui.delete.DeleteViewModel
import com.example.a10wordapp.ui.home.HomeViewModel
import com.example.a10wordapp.ui.list.ListViewModel
import com.example.a10wordapp.ui.quiz.QuizViewModel

class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {
//        @Suppress("unchecked_cast")
//        override fun <T : ViewModel> create(modelClass: Class<T>) =
//            QuizViewModel(dataRepository,quizRepository) as T
//    }

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(QuizViewModel::class.java) ->
                    QuizViewModel(DataRepository(), QuizRepository())
                isAssignableFrom(ListViewModel::class.java) ->
                    ListViewModel(DataRepository(), GetListViewRepository(), AddArrayRepository())
                isAssignableFrom(DeleteViewModel::class.java) ->
                    DeleteViewModel(DataRepository())
                isAssignableFrom(AddViewModel::class.java) ->
                    AddViewModel(DataRepository())
                isAssignableFrom(HomeViewModel::class.java) ->
                    HomeViewModel()
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