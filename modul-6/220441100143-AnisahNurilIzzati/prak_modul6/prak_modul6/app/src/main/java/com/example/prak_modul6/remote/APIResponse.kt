package com.example.prak_modul6.remote

import com.google.gson.annotations.SerializedName

data class APIResponse (
    @field:SerializedName("error") //menyamakan key yg ada di api dengan yg disini
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("count")
    val count: Int,

    @field:SerializedName("data")
    val data: List<PlayerData>
)