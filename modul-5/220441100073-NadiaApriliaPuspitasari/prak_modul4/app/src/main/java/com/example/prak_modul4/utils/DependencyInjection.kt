package com.example.prak_modul4.utils

import android.content.Context
import com.example.prak_modul4.room.AppDatabase
import com.example.prak_modul4.room.PostRepository

object DependencyInjection {
    // Menyediakan instance dari AppRepository
    fun provideRepository(context: Context): PostRepository {
        // Membuat instance dari AppDatabase
        val database = AppDatabase.getDatabase(context)
        // Membuat instance dari AppExecutors
        val appExecutors = AppExecutors()
        // Mendapatkan instance dari AppDao dari AppDatabase
        val dao = database.appDao()
        // Mendapatkan instance dari AppRepository menggunakan AppDao dan AppExecutors
        return PostRepository.getInstance(dao, appExecutors)
    }
}