package com.example.praktikum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ConstraintLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)

        val logoutm = findViewById<ImageView>(R.id.logoutm)
        logoutm.setOnClickListener{
            val intent = Intent(this, constraint_layout2::class.java)
            startActivity(intent)
        }
    }
}