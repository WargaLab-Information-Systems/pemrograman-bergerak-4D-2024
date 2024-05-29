package com.example.prak_modul4.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

/**
 * Fungsi insertPlayer(player: PlayerDatabase) digunakan untuk memasukkan data pemain ke dalam database.
 * Fungsi ini memanggil fungsi insertPlayer di AppRepository.
 *
 * Fungsi getAllPlayer() digunakan untuk mendapatkan semua data pemain dari database.
 * Fungsi ini memanggil fungsi getAllPlayer di AppRepository dan mengembalikan LiveData yang berisi daftar semua pemain.
 */

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {

    // Memasukkan data pemain ke dalam database
    fun insertPost(post: PostDatabase) {
        postRepository.insertPost(post)
    }

    // Mendapatkan semua data pemain dari database
    fun getAllPost(): LiveData<List<PostDatabase>> {
        return postRepository.getAllPost()
    }

//    fun deletePost(post: PostDatabase) {
//        postRepository.deletePost(post)
//    }
}