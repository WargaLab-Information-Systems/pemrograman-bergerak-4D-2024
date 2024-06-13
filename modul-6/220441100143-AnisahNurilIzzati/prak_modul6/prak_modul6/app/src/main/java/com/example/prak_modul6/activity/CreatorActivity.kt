package com.example.prak_modul6.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.media.MediaScannerConnection
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.bumptech.glide.Glide
import com.example.prak_modul6.R
import com.google.android.material.imageview.ShapeableImageView
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class CreatorActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1
    private lateinit var imageProfile: ShapeableImageView
    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creator)

        val iconBackCreator = findViewById<ShapeableImageView>(R.id.backFromCreator)
        iconBackCreator.setOnClickListener {
            finish()
        }

        imageProfile = findViewById(R.id.shapeableImageView)
        val buttonChangePhoto = findViewById<Button>(R.id.buttonChangePhoto)

        buttonChangePhoto.setOnClickListener {
            openImageChooser()
        }

        val buttonSavePhoto = findViewById<Button>(R.id.buttonSavePhoto)
        buttonSavePhoto.setOnClickListener {
            saveImage()
        }

        // Load image from cache or internal storage
        loadCachedImage()
    }

    private fun openImageChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            selectedImageUri = data.data
            try {
                Glide.with(this)
                    .load(selectedImageUri)
                    .into(imageProfile)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun saveImage() {
        val drawable = imageProfile.drawable
        val bitmap = (drawable as BitmapDrawable).bitmap

        // Ubah path penyimpanan gambar menjadi internal storage aplikasi
        val directory = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "MyApp")
        if (!directory.exists()) {
            directory.mkdirs()
        }

        // Buat nama file unik
        val fileName = "my_image.jpg"
        val file = File(directory, fileName)

        try {
            val stream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()

            // MediaScanner akan memperbarui MediaStore setelah menyimpan gambar
            MediaScannerConnection.scanFile(this, arrayOf(file.path), arrayOf("image/jpeg"), null)

            Toast.makeText(this, "Image saved successfully", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show()
        }
    }



    private fun loadCachedImage() {
        if (selectedImageUri != null) {
            Glide.with(this)
                .load(selectedImageUri)
                .into(imageProfile)
        }
    }
}