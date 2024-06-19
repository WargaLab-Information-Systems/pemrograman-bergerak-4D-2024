package com.example.praktikum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Beranda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)
    }

    fun Ini(view: View) {
        val intent = Intent(this, profil::class.java)
        startActivity(intent)
    }
}