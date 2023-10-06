package com.example.todoapplication.ui.viewModel


import androidx.lifecycle.ViewModel
import com.example.todoapplication.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoDetailViewModel  @Inject constructor(var taskRepository: TaskRepository) : ViewModel() {

    fun updateTask(task_id :Int, task_name: String, task_description: String){
        CoroutineScope(Dispatchers.Main).launch {
            taskRepository.updateTask(task_id,task_name, task_description)
        }
    }
}