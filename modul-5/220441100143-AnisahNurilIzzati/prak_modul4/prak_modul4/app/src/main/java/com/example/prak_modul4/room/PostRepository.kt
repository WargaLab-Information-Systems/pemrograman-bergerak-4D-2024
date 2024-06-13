package com.example.prak_modul4.room

import androidx.lifecycle.LiveData
import com.example.prak_modul4.utils.AppExecutors

// Kelas PeopleRepository adalah kelas yang bertugas untuk menghubungkan Dao dan ViewModel.
class PostRepository private constructor(
    // Variabel appDao adalah instance dari PeopleDao yang akan digunakan untuk mengakses database.
    private val postDao: PostDao,
    // Variabel appExecutors adalah instance dari AppExecutors yang akan digunakan untuk menjalankan operasi database di thread yang berbeda dari thread UI.
    private val appExecutors: AppExecutors) {

    // Mendapatkan semua data pemain dari database
    fun getAllPost(): LiveData<List<PostDatabase>> = postDao.getAllPost()

    // Memasukkan data pemain ke dalam database
    fun insertPost(post: PostDatabase) {
        // Menjalankan operasi insert di thread yang berbeda
        appExecutors.diskIO().execute {
            postDao.insertPost(post) }
    }

    fun updatePost(post: PostDatabase) {
        appExecutors.diskIO().execute {
            postDao.updatePost(post)
        }
    }

    fun deletePost(post: PostDatabase) {
        appExecutors.diskIO().execute {
            postDao.deletePost(post)
        }
    }


    // Fungsi getInstance digunakan untuk mendapatkan instance dari PeopleRepository.
    // Jika instance sudah ada, fungsi ini akan mengembalikan instance tersebut.
    // Jika instance belum ada, fungsi ini akan membuat instance baru.
    companion object {
        // Variabel untuk menyimpan instance dari AppRepository
        @Volatile
        private var instance: PostRepository? = null

        // Mendapatkan instance dari AppRepository
        fun getInstance(
            postDao: PostDao,
            appExecutors: AppExecutors
        ): PostRepository =
            // Jika instance null, maka akan dibuat instance baru
            instance ?: synchronized(this) {
                instance ?: PostRepository(postDao, appExecutors)
            }.also { instance = it }
    }
}