package com.example.m4.activity

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.esafirm.imagepicker.features.ImagePickerConfig
import com.esafirm.imagepicker.features.ImagePickerMode
import com.esafirm.imagepicker.features.ReturnMode
import com.esafirm.imagepicker.features.registerImagePicker
import com.example.m4.R
import com.example.m4.room.PostDatabase
import com.example.m4.room.PostViewModel
import com.example.m4.room.PostViewModelFactory
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.example.m4.utils.reduceFileImage
import com.example.m4.utils.uriToFile
import java.io.File

class UpdatePeopleRoomActivity : AppCompatActivity() {

    // Mendeklarasikan variabel untuk menyimpan URI gambar saat ini dan foto lama.
    private var currentImageUri: Uri? = null
    private var oldPhoto: File? = null

    private lateinit var peopleName: TextInputEditText
    private lateinit var peopleDescription: TextInputEditText
    private lateinit var peopleImage: TextInputEditText
    private lateinit var peopleImagePlace: ImageView
    private lateinit var getDataPostDatabase: PostDatabase
    private lateinit var postViewModel: PostViewModel

    // Mendeklarasikan imagePickerLauncher untuk memilih gambar dari galeri atau kamera.
    private val imagePickerLauncher = registerImagePicker {
        val firstImage = it.firstOrNull() ?: return@registerImagePicker
        if (firstImage.uri.toString().isNotEmpty()) {
            peopleImagePlace.visibility = View.VISIBLE
            currentImageUri = firstImage.uri

            // Menggunakan Glide untuk memuat gambar ke ImageView.
            Glide.with(peopleImagePlace)
                .load(firstImage.uri)
                .into(peopleImagePlace)
        } else {
            View.GONE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_post)

        getDataPostDatabase = intent.getParcelableExtra("post")!!

        val factory = PostViewModelFactory.getInstance(this)
        postViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]

        peopleImagePlace = findViewById(R.id.id_add)
        peopleName = findViewById(R.id.post_desc_edit)
        peopleDescription = findViewById(R.id.post_desc_edit)

        peopleName.setText(getDataPostDatabase.name)
        peopleDescription.setText(getDataPostDatabase.description)
        Glide.with(this)
            .load(getDataPostDatabase.image)
            .into(peopleImagePlace)

        oldPhoto = getDataPostDatabase.image

        onClick()
    }

    private fun onClick() {
        val savedBtn = findViewById<MaterialButton>(R.id.btn_savedPost)
        savedBtn.setOnClickListener {
            if (validateInput()) {
                savedData()
            }
        }

        // Menangani aksi klik pada TextInputEditText untuk membuka image picker.
        val openImagePicker = findViewById<ImageView>(R.id.id_add)
        openImagePicker.setOnClickListener {
            imagePickerLauncher.launch(
                ImagePickerConfig {
                    mode = ImagePickerMode.SINGLE
                    returnMode = ReturnMode.ALL
                    isFolderMode = true
                    folderTitle = "Galeri"
                    isShowCamera = false
                    imageTitle = "Tekan untuk memilih gambar"
                    doneButtonText = "Selesai"
                }
            )
        }
    }

    private fun validateInput(): Boolean {
        var error = 0

        // Jika input kosong, tambahkan pesan error.
        if (peopleName.text.toString().isEmpty()) {
            error++
            peopleName.error = "deskripsi tidak boleh kosong"
        }

        // Jika input deskripsi kosong, tambahkan pesan error. Add this block
        if (peopleDescription.text.toString().isEmpty()) {
            error++
            peopleDescription.error = "deskripsi tidak boleh kosong"
        }

        // Jika tidak ada error, kembalikan true. Jika ada, kembalikan false.
        return error == 0
    }

    private fun savedData() {
        // Mengurangi ukuran file gambar.
        val imageFile = currentImageUri?.let { uriToFile(it, this).reduceFileImage() }

        // Membuat objek PlayerEntity baru dengan data yang diperbarui.
        val post = (if (currentImageUri != null) imageFile else oldPhoto)?.let {
            PostDatabase(
                id = getDataPostDatabase.id,
                name = peopleName.text.toString(),
                description = peopleDescription.text.toString(), // Add this line
                image = it
            )
        }

        Log.d("people", post.toString())

        // Memperbarui data pemain di database.
        if (post != null) postViewModel.updatePost(post)

        // Menampilkan pesan bahwa data pemain berhasil diubah.
        Toast.makeText(
            this@UpdatePeopleRoomActivity,
            "Data  berhasil diubah",
            Toast.LENGTH_SHORT
        ).show()

        // Menutup activity.
        finish()
    }

    private fun PostDatabase(id: Int, name: String, description: String, image: File): PostDatabase {
        return PostDatabase(id, name, description, image, 0)
    }

}
