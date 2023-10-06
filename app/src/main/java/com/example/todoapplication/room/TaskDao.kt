package com.example.todoapplication.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapplication.data.model.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    suspend fun getTasks() : List<Task>

    @Insert
    suspend fun saveTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM tasks WHERE task_name like '%' || :searchedWord || '%'")
    suspend fun searchTask(searchedWord: String) : List<Task>
}