package com.example.tugas_modul_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<MaterialButton>(R.id.tombol)
        button.setOnClickListener {
            val intent = Intent (this, BerandaActivity::class.java)
            startActivity(intent)
        }
    }
}