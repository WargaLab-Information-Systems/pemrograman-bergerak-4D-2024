package com.example.abc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class berandaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        val logo = findViewById<ImageView>(R.id.logopojok)
        logo.setOnClickListener {
            val intent = Intent (this,profilActivity:: class.java)
            startActivity(intent)
        }
    }
}