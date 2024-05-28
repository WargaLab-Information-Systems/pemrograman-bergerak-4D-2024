package com.example.m4.utils

import android.content.Context
import com.example.m4.room.AppDatabase
import com.example.m4.room.PostRepository

object DependencyInjection {
    fun provideRepository(context: Context): PostRepository {
        val database = AppDatabase.getDatabase(context)
        val appExecutors = AppExecutors()
        val dao = database.postDao()
        return PostRepository.getInstance(dao, appExecutors)
    }
}