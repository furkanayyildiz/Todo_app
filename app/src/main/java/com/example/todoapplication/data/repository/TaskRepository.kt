package com.example.todoapplication.data.repository

import com.example.todoapplication.data.datasource.TaskDataSource
import com.example.todoapplication.data.model.Task

class TaskRepository(var taskDataSource: TaskDataSource) {

    suspend fun  getTasks() : List<Task> = taskDataSource.getTasks()

    suspend fun saveTask(task_name : String, task_description :String) =  taskDataSource.saveTask(task_name,task_description)

    suspend fun updateTask(task_id :Int, task_name: String, task_description: String) = taskDataSource.updateTask(task_id,task_name,task_description)

    suspend fun deleteTask(task_id: Int) = taskDataSource.deletetask(task_id)

    suspend fun searchTask(searchedTask : String) : List<Task> = taskDataSource.searchTask(searchedTask)
}