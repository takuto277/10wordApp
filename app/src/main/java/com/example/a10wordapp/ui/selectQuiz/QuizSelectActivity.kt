//package com.example.a10wordapp.ui.selectQuiz
//
//import QuizSelectRecyclerViewAdapter
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.Toast
//import androidx.activity.viewModels
//import androidx.recyclerview.widget.DividerItemDecoration
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.a10wordapp.R
//import com.example.a10wordapp.ViewModelFactory
//import com.example.a10wordapp.databinding.ActivityQuizSelectBinding
//import com.example.a10wordapp.domain.entity.QuestionListItem
//
//
//class QuizSelectActivity : AppCompatActivity() {
//
//    private val viewModel: QuizSelectViewModel by viewModels {ViewModelFactory(applicationContext)}
//    val listItem: Array<String> = arrayOf("englsih","japanese")
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_quiz_select)
//        val binding = ActivityQuizSelectBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        viewModel.questionListItem.observe(this) {
//            initListAdapter(binding.recyclerView, listItem)
//        }
//        viewModel.fetchContent()
//    }
//
//    private fun initListAdapter(recyclerView: RecyclerView, dataSet: Array<String>) {
//        val quizSelectRecyclerViewAdapter = QuizSelectRecyclerViewAdapter(dataSet)
//        quizSelectRecyclerViewAdapter.itemClickListener = object : QuizSelectRecyclerViewAdapter.OnItemClickListener {
//            override fun onItemClick(item: String) {
//                Toast.makeText(
//                    this@QuizSelectActivity,
//                    "「${item}」をクリックしました。",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//        recyclerView.apply {
//            adapter = quizSelectRecyclerViewAdapter
//            addItemDecoration(
//                DividerItemDecoration(
//                    this@QuizSelectActivity,
//
//                    LinearLayoutManager(this@QuizSelectActivity).orientation
//                )
//            )
//        }
//    }
//}