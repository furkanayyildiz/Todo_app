package com.example.todoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapplication.R
import com.example.todoapplication.databinding.FragmentTodoDetailBinding
import com.example.todoapplication.ui.viewModel.TodoDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoDetailFragment : Fragment() {

    private lateinit var binding: FragmentTodoDetailBinding
    private lateinit var viewModel: TodoDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoDetailBinding.inflate(inflater, container, false)

        val bundle: TodoDetailFragmentArgs by navArgs()
        val task = bundle.task

        binding.editTextTaskName.setText(task.task_name)
        binding.editTextTaskDescription.setText(task.task_description)

        binding.buttonUpdate.setOnClickListener {
            val task_name = binding.editTextTaskName.text.toString()
            val task_description = binding.editTextTaskDescription.text.toString()
            updateTask(task.task_id,task_name,task_description)

        }

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : TodoDetailViewModel by viewModels()
        viewModel = tempViewModel
    }
     fun updateTask(task_id:Int, task_name:String, task_description: String){
        viewModel.updateTask(task_id,task_name,task_description)

    }

}