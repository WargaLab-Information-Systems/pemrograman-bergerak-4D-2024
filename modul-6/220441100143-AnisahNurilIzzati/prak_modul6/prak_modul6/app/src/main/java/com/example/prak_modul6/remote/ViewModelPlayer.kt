package com.example.prak_modul6.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class ViewModelPlayer (private val repository: Repository) : ViewModel() {
    // Mendeklarasikan variabel listPlayer yang berisi LiveData dari List APIResponse dari repository
    val listPlayer: LiveData<List<PlayerData>> = repository.listPlayer

    // Mendeklarasikan variabel isLoading yang berisi LiveData dari Boolean (status loading) dari repository
    val isLoading: LiveData<Boolean> = repository.isLoading

    // Fungsi untuk mendapatkan semua pemain dari repository
    fun getAllPlayer() {
        repository.getAllPlayer()
    }
}