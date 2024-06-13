package com.example.prak_modul6.remote

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("tugas")
    fun getAllPlayer() : Call<APIResponse>
}