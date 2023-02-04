package com.example.a10wordapp.ui.quizlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.databinding.ActivityQuizlistBinding
import com.example.a10wordapp.domain.entity.QuizListItem
import com.example.a10wordapp.ui.ViewModelFactory
import com.example.a10wordapp.ui.quizlist.adapter.QuizListAdapter

class QuizListActivity : Fragment() {
    // private val requireContext = requireContext()
    private val viewModel: QuizListViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: ActivityQuizlistBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityQuizlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.quizListItem.observe(viewLifecycleOwner) { listItems ->
            initListAdapter(binding.mainList, listItems)
        }
        viewModel.fetchContent()
    }

    private fun initListAdapter(recyclerView: RecyclerView, dataSet: Array<QuizListItem>) {
        val quizListAdapter = QuizListAdapter(dataSet)
        quizListAdapter.itemClickListener = object : QuizListAdapter.OnItemClickListener {
            override fun onItemClick(item: QuizListItem) {
                Toast.makeText(
                    requireContext(),
                    "「${item.text}」をクリックしました。",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        recyclerView.apply {
            adapter = quizListAdapter
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    LinearLayoutManager(requireContext()).orientation
                )
            )
        }
    }
}