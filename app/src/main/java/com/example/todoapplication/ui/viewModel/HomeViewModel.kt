package com.example.todoapplication.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapplication.data.model.Task
import com.example.todoapplication.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var taskRepository: TaskRepository) : ViewModel() {

    var taskList = MutableLiveData<List<Task>>()

    init {
        getTasks()
    }
    fun getTasks() {
        CoroutineScope(Dispatchers.Main).launch {
            taskList.value = taskRepository.getTasks()
        }
    }
    fun deleteTask(task_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            taskRepository.deleteTask(task_id)
            getTasks()
        }
    }
    fun searchTask(searchedTask : String){
        CoroutineScope(Dispatchers.Main).launch {
            taskList.value = taskRepository.searchTask(searchedTask)
        }
    }
}