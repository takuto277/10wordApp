package com.example.a10wordapp.ui.quizdelete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.databinding.ActivityDeleteBinding
import com.example.a10wordapp.ui.ViewModelFactory
import com.example.a10wordapp.ui.quizdelete.adapter.RecyclerAdapter

class QuizDeleteActivity : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityDeleteBinding

    // private val requireContext = requireContext()
    private val viewModel: QuizDeleteViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityDeleteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getInitialDataList()
        val initialDataList = viewModel.list.value ?: return

        recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        recyclerView.adapter = RecyclerAdapter(initialDataList)
    }
}