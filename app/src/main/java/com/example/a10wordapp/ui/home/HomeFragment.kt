package com.example.a10wordapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.a10wordapp.R
import com.example.a10wordapp.databinding.HomeFragmentBinding
import com.example.a10wordapp.ui.ViewModelFactory
import com.example.a10wordapp.ui.main.MainViewModel
import com.example.a10wordapp.ui.quizadd.QuizAddFragment
import com.example.a10wordapp.ui.quizdelete.QuizDeleteFragment
import com.example.a10wordapp.ui.quizlist.QuizListFragment
import com.example.a10wordapp.ui.quizselect.QuizSelectFragment

class HomeFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels { ViewModelFactory(requireContext()) }
    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.changePlan(isChecked)
            binding.addButton.isVisible = !isChecked
            binding.FetchInitialWordsButton.isVisible = isChecked
        }

        binding.learnButton.setOnClickListener {
            changeFragment(QuizSelectFragment())
        }

        binding.addButton.setOnClickListener {
            changeFragment(QuizAddFragment())
        }

        binding.deleteButton.setOnClickListener {
            changeFragment(QuizDeleteFragment())
        }

        binding.allButton.setOnClickListener {
            changeFragment(QuizListFragment())
        }

        binding.FetchInitialWordsButton.setOnClickListener {
            viewModel.fetchInitialWords()

        }

        viewModel.english.observe(viewLifecycleOwner, androidx.lifecycle.Observer { english ->
            Toast.makeText(
                requireContext(),
                "初期単語を取得しました。",
                Toast.LENGTH_SHORT
            ).show()
        })
    }

    private fun changeFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null);
        transaction.commit()
    }
}
