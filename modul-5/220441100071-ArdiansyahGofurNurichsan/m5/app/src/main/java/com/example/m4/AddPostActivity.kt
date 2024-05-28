package com.example.m4


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.esafirm.imagepicker.features.ImagePickerConfig
import com.esafirm.imagepicker.features.ImagePickerMode
import com.esafirm.imagepicker.features.ReturnMode
import com.esafirm.imagepicker.features.registerImagePicker
import com.example.m4.room.PostDatabase
import com.example.m4.room.PostViewModel
import com.example.m4.room.PostViewModelFactory
import com.example.m4.utils.reduceFileImage
import com.example.m4.utils.uriToFile
import com.google.android.material.textfield.TextInputEditText
import kotlin.random.Random


class AddPostActivity : AppCompatActivity() {


    private var currentImageUri: Uri? = null
    private lateinit var postViewModel: PostViewModel
    private lateinit var vPostDesc: TextInputEditText
    private lateinit var vPostImage: ImageView
    private lateinit var vText_img: TextView

    private val imagePickerLauncher = registerImagePicker {
        val firstImage = it.firstOrNull() ?: return@registerImagePicker
        if (firstImage.uri.toString().isNotEmpty()) {
            vPostImage.visibility = View.VISIBLE
            currentImageUri = firstImage.uri
            vText_img.setText("change")
            Glide.with(vPostImage)
                .load(firstImage.uri)
                .into(vPostImage)
        } else {
            View.GONE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_post)
        val factory = PostViewModelFactory.getInstance(this)
        postViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]

        vPostImage = findViewById(R.id.id_add)
        vPostDesc = findViewById(R.id.post_desc_edit)
        vText_img = findViewById(R.id.text_img)
        onClick()
    }

    private fun onClick() {
        val openImagePicker = findViewById<ImageView>(R.id.id_add)
        openImagePicker.setOnClickListener {
            imagePickerLauncher.launch(
                ImagePickerConfig {
                    mode = ImagePickerMode.SINGLE
                    returnMode = ReturnMode.ALL
                    isFolderMode = true
                    folderTitle = "Galeri"
                    isShowCamera = false
                    imageTitle = "Click to choice the image"
                    doneButtonText = "Done"
                }
            )
        }

        val btnSavedPlayer = findViewById<Button>(R.id.btn_savedPost)
        btnSavedPlayer.setOnClickListener {
            if (validateInput()) {
                savedData()
            }
        }
    }

    private fun validateInput(): Boolean {
        var error = 0

        if (vPostDesc.text.toString().isEmpty()) {
            error++
            vPostDesc.error = "Desc is not empty!"
        }
        if (vText_img.text.toString() == "add") {
            error++
            vText_img.error = "Image is not Empty!"
        }

        return error == 0
    }

    private fun savedData() {
        val imageFile = currentImageUri?.let { uriToFile(it, this).reduceFileImage() }

        val post = imageFile?.let {
            val descriptionText = vPostDesc.text.toString()
            val words = descriptionText.split(" ")
            val firstTwoWords = words.take(2).joinToString(" ")
            PostDatabase(
                id = 0,
                name = firstTwoWords,
                description = descriptionText,
                image = imageFile,
                like = Random.nextInt(0, 1)
            )
        }

        if (post != null) postViewModel.insertPost(post)

        Toast.makeText(
            this@AddPostActivity,
            "Data Success Added",
            Toast.LENGTH_SHORT
        ).show()

        finish()
    }

    fun toMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}