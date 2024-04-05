package com.example.registar.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dagger.hilt.InstallIn

@InstallIn
@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao():UsersDao
}