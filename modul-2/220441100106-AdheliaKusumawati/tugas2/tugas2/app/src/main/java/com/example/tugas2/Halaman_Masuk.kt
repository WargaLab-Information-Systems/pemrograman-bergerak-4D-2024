package com.example.tugas2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile

class Halaman_Masuk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val constraintView = findViewById<com.google.android.material.button.MaterialButton>(R.id.constraint_view_LANJUT)
        constraintView.setOnClickListener {
            val intent = Intent(this,Halaman_Beranda::class.java)
            startActivity(intent)
        }
    }
}
