package com.example.prak_modul4.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

// Kelas PeopleViewModel adalah kelas yang bertugas untuk menghubungkan Repository dan UI.
// Kelas ini mewarisi ViewModel, yang merupakan kelas dari Android Architecture Components yang digunakan untuk menyimpan dan mengelola data yang terkait dengan UI.
class PostViewModel(private val postRepository: PostRepository) : ViewModel() {

    // Memasukkan data pemain ke dalam database
    fun insertPost(post: PostDatabase) {
        postRepository.insertPost(post)
    }

    // Mendapatkan semua data pemain dari database
    fun getAllPost(): LiveData<List<PostDatabase>> {
        return postRepository.getAllPost()
    }

    fun updatePost(post: PostDatabase) {
        postRepository.updatePost(post)
    }

    fun deletePost(post: PostDatabase) {
        postRepository.deletePost(post)
    }

}