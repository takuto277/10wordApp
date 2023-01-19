package com.example.a10wordapp

import androidx.lifecycle.ViewModelProvider
import com.example.a10wordapp.repository.QuizRepository
import com.example.a10wordapp.ui.quiz.QuizViewModel

//class ViewModelFactory private constructor(
//    private val quizRepository: QuizRepository
//) : ViewModelProvider.NewInstanceFactory() {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>) =
//        with(modelClass) {
//            when {
//                isAssignableFrom(QuizViewModel::class.java) ->
//                    QuizViewModel(quizRepository)
//                isAssignableFrom(TaskDetailViewModel::class.java) ->
//                    TaskDetailViewModel(QuizRepository)
//                isAssignableFrom(AddEditTaskViewModel::class.java) ->
//                    AddEditTaskViewModel(QuizRepository)
//                isAssignableFrom(TasksViewModel::class.java) ->
//                    TasksViewModel(QuizRepository)
//                else ->
//                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
//            }
//        } as T
//
//    companion object {
//
//        @SuppressLint("StaticFieldLeak")
//        @Volatile private var INSTANCE: ViewModelFactory? = null
//
//        fun getInstance(application: Application) =
//            INSTANCE ?: synchronized(ViewModelFactory::class.java) {
//                INSTANCE ?: ViewModelFactory(
//                    Injection.provideTasksRepository(application.applicationContext))
//                    .also { INSTANCE = it }
//            }
//
//
//        @VisibleForTesting fun destroyInstance() {
//            INSTANCE = null
//        }
//    }
//}