package com.example.tugas2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Halaman_Beranda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_beranda)

        val kliklogo = findViewById<ImageButton>(R.id.my_image_button)
        kliklogo.setOnClickListener {
            val intent = Intent(this, Halaman_Profile::class.java)
            startActivity(intent)
        }
    }
}
