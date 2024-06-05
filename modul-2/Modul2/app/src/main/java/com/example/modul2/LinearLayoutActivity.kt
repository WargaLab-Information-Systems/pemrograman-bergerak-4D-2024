package com.example.modul2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class LinearLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)

        val logo = findViewById<ImageView>(R.id.imageViewh3)
        logo.setOnClickListener {
            val namaActivityIntent = Intent(this, ProfileActivity::class.java)
            startActivity(namaActivityIntent)
        }
    }
}