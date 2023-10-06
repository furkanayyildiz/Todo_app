package com.example.todoapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapplication.R
import com.example.todoapplication.databinding.FragmentHomeBinding
import com.example.todoapplication.ui.adapter.TaskAdapter
import com.example.todoapplication.ui.viewModel.HomeViewModel
import com.example.todoapplication.utils.viewNavigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.recyclerViewTasks.layoutManager = LinearLayoutManager(requireContext())

        viewModel.taskList.observe(viewLifecycleOwner){
            val taskAdapter = TaskAdapter(requireContext(), it, viewModel)
            binding.recyclerViewTasks.adapter = taskAdapter
        }

        binding.fab.setOnClickListener {
            Navigation.viewNavigate(it,R.id.navigationHomeToSave)
        }

        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                searchTask(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                searchTask(query)
                return false
            }
        })
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomeViewModel by viewModels()
        viewModel = tempViewModel
    }
    override fun onResume() {
        super.onResume()
        viewModel.getTasks()
        Log.e("Kişi Anasayfa", "Dönüldü")
    }
    fun searchTask(searchedTask : String){
        viewModel.searchTask(searchedTask)
    }
}