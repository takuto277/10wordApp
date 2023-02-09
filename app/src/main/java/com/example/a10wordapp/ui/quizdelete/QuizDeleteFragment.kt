package com.example.a10wordapp.ui.quizdelete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.databinding.QuizDeleteFragmentBinding
import com.example.a10wordapp.ui.ViewModelFactory
import com.example.a10wordapp.ui.main.MainViewModel
import com.example.a10wordapp.ui.quizdelete.adapter.RecyclerAdapter

class QuizDeleteFragment : Fragment() {
    private val mainViewModel: MainViewModel by activityViewModels { ViewModelFactory(requireContext()) }
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: QuizDeleteFragmentBinding
    private val viewModel: QuizDeleteViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = QuizDeleteFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.plan.observe(viewLifecycleOwner, Observer { plan ->
            viewModel.getQuiz(plan)
        })

        viewModel.quizItemArray.observe(viewLifecycleOwner, Observer { array ->
            recyclerView = binding.recyclerView
            recyclerView.setHasFixedSize(true)

            recyclerView.layoutManager =
                GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
            recyclerView.adapter = RecyclerAdapter(array)
        })
    }
}