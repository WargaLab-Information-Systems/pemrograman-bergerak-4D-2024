package com.example.modul2_praktikum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class beranda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)
    }

    fun menuju_profile(view: View) {
        val intent = Intent(this, profile::class.java)
        startActivity(intent)
    }
}