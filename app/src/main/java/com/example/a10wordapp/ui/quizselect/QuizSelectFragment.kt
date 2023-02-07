package com.example.a10wordapp.ui.quizselect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a10wordapp.R
import com.example.a10wordapp.databinding.QuizSelectFragmentBinding
import com.example.a10wordapp.domain.item.QuizSelectItem
import com.example.a10wordapp.ui.ViewModelFactory
import com.example.a10wordapp.ui.main.MainViewModel
import com.example.a10wordapp.ui.quizselect.adapter.QuizSelectAdapter
import com.example.a10wordapp.ui.quizshow.QuizShowFragment

class QuizSelectFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels { ViewModelFactory(requireContext()) }
    private val viewModel: QuizSelectViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: QuizSelectFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = QuizSelectFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.quizSelectItem.observe(viewLifecycleOwner, Observer { listItems ->
            initListAdapter(binding.recyclerView, listItems)
        })
        viewModel.fecthContent(mainViewModel.plan.value!!)
    }

    private fun initListAdapter(recyclerView: RecyclerView, dataSet: Array<QuizSelectItem>) {
        val quizSelectAdapter = QuizSelectAdapter(dataSet)
        quizSelectAdapter.itemClickListener = object : QuizSelectAdapter.onItemClickListener {
            override fun onItemClick(item: QuizSelectItem) {
                Toast.makeText(
                    requireContext(),
                    "「${item.id}」をクリックしました。",
                    Toast.LENGTH_SHORT
                ).show()

                mainViewModel.registerQuizWords(mainViewModel.plan.value!!, item.id)
                val fragment = QuizShowFragment()
                val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment, fragment)
                transaction.addToBackStack(null);
                transaction.commit()
            }
        }
        recyclerView.apply {
            adapter = quizSelectAdapter
            layoutManager = GridLayoutManager(requireContext(), 4)
        }
    }
}