package com.example.modul2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lanjutButton = findViewById<Button>(R.id.buttonh1)
        lanjutButton.setOnClickListener {
            val namaActivityIntent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(namaActivityIntent)
        }
    }
}