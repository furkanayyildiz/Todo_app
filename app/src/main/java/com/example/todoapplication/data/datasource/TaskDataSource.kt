package com.example.todoapplication.data.datasource

import com.example.todoapplication.data.model.Task
import com.example.todoapplication.room.TaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskDataSource(var taskDao: TaskDao) {

    suspend fun getTasks() : List<Task> = withContext(Dispatchers.IO) {

        return@withContext taskDao.getTasks()
    }

    suspend fun saveTask(task_name : String, task_description : String){
        val newTask = Task(0,task_name,task_description)
        taskDao.saveTask(newTask)
    }

    suspend fun updateTask(task_id : Int , task_name: String, task_description: String){
        val updatedTask = Task(task_id,task_name,task_description)
        taskDao.updateTask(updatedTask)
    }
    suspend fun deletetask(task_id: Int){
        val deletedTask = Task(task_id,"", "")
        taskDao.deleteTask(deletedTask)
    }
    suspend fun searchTask(searchedWord : String) : List<Task> = withContext(Dispatchers.IO) {
        return@withContext taskDao.searchTask(searchedWord)
    }
}