package com.example.todoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todoapplication.R
import com.example.todoapplication.databinding.FragmentTodoSaveBinding
import com.example.todoapplication.ui.viewModel.TodoSaveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoSaveFragment : Fragment() {

    private lateinit var binding: FragmentTodoSaveBinding
    private lateinit var viewModel: TodoSaveViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoSaveBinding.inflate(inflater, container, false)

        binding.buttonSave.setOnClickListener {
            val task_name = binding.editTextTaskName.text.toString()
            val task_description = binding.editTextTaskDescription.text.toString()
            saveTask(task_name,task_description)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : TodoSaveViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun saveTask(task_name:String, task_description:String){
        viewModel.saveTask(task_name , task_description )
    }

}