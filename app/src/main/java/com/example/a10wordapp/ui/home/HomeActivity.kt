package com.example.a10wordapp.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import com.example.a10wordapp.R
import com.example.a10wordapp.databinding.ActivityHomeBinding
import com.example.a10wordapp.ui.ViewModelFactory
import com.example.a10wordapp.ui.quizadd.QuizAddActivity


class HomeActivity : Fragment() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityHomeBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.activity_home, container, false)
    }

    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addButton.setOnClickListener {
            val fragment = QuizAddActivity()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment, fragment)
            transaction.addToBackStack(null);
            transaction.commit()
        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
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
