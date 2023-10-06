package com.example.todoapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapplication.data.model.Task

@Database(entities = [Task:: class], version = 1)
abstract class Database : RoomDatabase(){
    abstract fun getTaskDao() : TaskDao
}