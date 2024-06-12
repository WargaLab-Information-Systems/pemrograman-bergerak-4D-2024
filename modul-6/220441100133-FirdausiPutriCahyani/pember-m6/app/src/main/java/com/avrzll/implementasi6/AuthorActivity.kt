package com.avrzll.implementasi6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import com.google.android.material.imageview.ShapeableImageView

class AuthorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author)

        val iconBackCreator = findViewById<ShapeableImageView>(R.id.backFromCreator)
        iconBackCreator.setOnClickListener {
            finish()
        }

        // Tambahkan bagian berikut
        val editTextName = findViewById<EditText>(R.id.editTextText)
        val btnUbah = findViewById<Button>(R.id.btn_ubah)

        btnUbah.setOnClickListener {
            val name = editTextName.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }
    }
}
