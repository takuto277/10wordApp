package com.example.a10wordapp.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a10wordapp.R


class HomeActivity : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_home, container, false)
    }
//    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(applicationContext) }
//    private lateinit var binding: ActivityHomeBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityHomeBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.learnButton.setOnClickListener {
//            val intent = Intent(this, QuizSelectActivity::class.java)
//            startActivity(intent)
//        }
//        binding.addButton.setOnClickListener {
//            val intent = Intent(this, QuizAddActivity::class.java)
//            startActivity(intent)
//        }
//        binding.deleteButton.setOnClickListener {
//            val intent = Intent(this, QuizDeleteActivity::class.java)
//            startActivity(intent)
//        }
//        binding.allButton.setOnClickListener {
//            val intent = Intent(this, QuizListActivity::class.java)
//            startActivity(intent)
//        }
//        binding.apiFetchButton.setOnClickListener {
//            viewModel.fetchAPI()
//        }
//
//        viewModel.english.observe(this, Observer { english ->
//            Toast.makeText(
//                this@HomeActivity,
//                "「${english}」を表示します。",
//                Toast.LENGTH_SHORT
//            ).show()
//        })
//    }
}
