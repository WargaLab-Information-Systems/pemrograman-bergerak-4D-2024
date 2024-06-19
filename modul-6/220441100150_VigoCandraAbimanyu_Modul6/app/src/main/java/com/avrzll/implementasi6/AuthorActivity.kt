package com.avrzll.implementasi6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class AuthorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author)


        enableEdgeToEdge()

        // Mendapatkan data nama dari intent
        val name = intent.getStringExtra("name")

        // Menampilkan nama pada TextView
        val nameTextView = findViewById<TextView>(R.id.textView10)
        nameTextView.text = "$name"
        val nameTextView1 = findViewById<TextView>(R.id.textView5)
        nameTextView1.text = "$name"

        val iconBackCreator = findViewById<ShapeableImageView>(R.id.backFromCreator)
        iconBackCreator.setOnClickListener {
            finish()
        }
    }
}