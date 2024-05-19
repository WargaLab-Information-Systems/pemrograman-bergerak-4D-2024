package com.example.tugas_modul_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.button.MaterialButton

class BerandaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        val logo = findViewById<ImageView>(R.id.judul_logo)
        logo.setOnClickListener {
            val intent = Intent (this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}