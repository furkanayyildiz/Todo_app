package com.example.todoapplication.di

import android.content.Context
import androidx.room.Room
import com.example.todoapplication.data.datasource.TaskDataSource
import com.example.todoapplication.data.repository.TaskRepository
import com.example.todoapplication.room.Database
import com.example.todoapplication.room.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideTaskRepository(taskDataSource: TaskDataSource) : TaskRepository {
        return TaskRepository(taskDataSource)
    }
    @Provides
    @Singleton
    fun provideTaskDataSource(taskDao: TaskDao) : TaskDataSource {
        return TaskDataSource(taskDao)
    }

    @Provides
    @Singleton
    fun provideTaskDao(@ApplicationContext context: Context) : TaskDao {
        val vt = Room.databaseBuilder(context, Database::class.java, "task.sqlite" )
            .createFromAsset("task.sqlite").build()
        return vt.getTaskDao()
    }


}