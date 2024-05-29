package com.example.modultiga

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val getDataName = intent.getStringExtra("name")
        val getDataDescription = intent.getStringExtra("detail")
        val getDataImage = intent.getIntExtra("image", 0)

        val playerName = findViewById<MaterialTextView>(R.id.textView13)
        val playerDescription = findViewById<MaterialTextView>(R.id.textView14)
        val playerImage = findViewById<ShapeableImageView>(R.id.imageView5)

        playerName.text = getDataName
        playerDescription.text = getDataDescription
        playerImage.setImageResource(getDataImage)

        val btnShare: ImageButton = findViewById<ImageButton>(R.id.imageButton)

        btnShare.setOnClickListener {

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "$getDataName\n\n$getDataDescription")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, "Bagikan menggunakan")

            startActivity(shareIntent)
        }
    }

    private fun isPackageInstalled(packageName: String): Boolean {
        return try {
            // Mencoba mendapatkan informasi paket
            packageManager.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            // Jika paket tidak ditemukan, kembalikan false
            false
        }
    }
}
