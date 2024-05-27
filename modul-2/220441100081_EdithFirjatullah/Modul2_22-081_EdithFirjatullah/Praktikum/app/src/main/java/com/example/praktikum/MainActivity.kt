package com.example.praktikum

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val masukapk = findViewById<MaterialButton>(R.id.masukapk)
        masukapk.setOnClickListener{
            val intent = Intent(this, ConstraintLayout::class.java)
            startActivity(intent)
        }
    }
}
