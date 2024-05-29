package com.example.prak_modul4.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.esafirm.imagepicker.features.ImagePickerConfig
import com.esafirm.imagepicker.features.ImagePickerMode
import com.esafirm.imagepicker.features.ReturnMode
import com.esafirm.imagepicker.features.registerImagePicker
import com.example.prak_modul4.MainActivity
import com.example.prak_modul4.R
import com.example.prak_modul4.room.PostDatabase
import com.example.prak_modul4.room.PostViewModel
import com.example.prak_modul4.room.PostViewModelFactory
import com.example.prak_modul4.utils.reduceFileImage
import com.example.prak_modul4.utils.uriToFile
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textfield.TextInputEditText
import java.io.File


class UpdatePostRoomActivity : AppCompatActivity() {

    private var currentImageUri: Uri? = null
    private var oldPhoto: File? = null
    private lateinit var vPostImage: ImageView
    private lateinit var postViewModel: PostViewModel
    private lateinit var vPostTitle: TextInputEditText
    private lateinit var vPostDesc: TextInputEditText
    private lateinit var vText_img: TextView
    private lateinit var getDataPost: PostDatabase

    private val imagePickerLauncher = registerImagePicker {
        val firstImage = it.firstOrNull() ?: return@registerImagePicker
        if (firstImage.uri.toString().isNotEmpty()) {
            vPostImage.visibility = View.VISIBLE
            currentImageUri = firstImage.uri
            Glide.with(vPostImage)
                .load(firstImage.uri)
                .into(vPostImage)
        } else {
            vPostImage.visibility = View.GONE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_post_room2)

        getDataPost = intent.getParcelableExtra("post")!!

        val factory = PostViewModelFactory.getInstance(this)
        postViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]
        vPostImage = findViewById(R.id.post_img_edit)
        vPostTitle = findViewById(R.id.post_title_edit)
        vText_img = findViewById(R.id.text_img)
        vPostDesc = findViewById(R.id.post_desc_edit)

        vPostTitle.setText(getDataPost!!.name)
        vPostDesc.setText(getDataPost!!.description)
        vText_img.text = "Change"
        Glide.with(this)
            .load(getDataPost.image)
            .into(vPostImage)

        oldPhoto = getDataPost.image

        OnClick()
    }

    private fun OnClick() {
        val openImagePicker = findViewById<ImageView>(R.id.post_img_edit)
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

        val btnSavedPlayer = findViewById<Button>(R.id.btn_savedPost)
        btnSavedPlayer.setOnClickListener {
            if (validateInput()) {
                savedData()
            }
        }
    }

    private fun validateInput(): Boolean {
        var error = 0
        if (vPostTitle.text.toString().isEmpty()) {
            error++
            vPostTitle.error = "Title is not empty!"
        }

        if (vPostDesc.text.toString().isEmpty()) {
            error++
            vPostDesc.error = "Desc is not empty!"
        }
//        if (vText_img.text.toString() == "add") {
//            error++
//            vText_img.error = "Image is not Empty!"
//        }

        return error == 0
    }

    private fun savedData() {
        val imageFile = currentImageUri?.let { uriToFile(it, this).reduceFileImage() }
        Log.d("UpdatePostRoomActivity", "CurrentImageUri: $currentImageUri")
        Log.d("UpdatePostRoomActivity", "Description: ${vPostDesc.text.toString()}")

        val post = (if (currentImageUri != null) imageFile else oldPhoto)?.let {
            PostDatabase(
                id = getDataPost.id,
                name = vPostTitle.text.toString(),
                description = vPostDesc.text.toString(),
                image = it,
                like = 10
            )
        }

//        val post = imageFile?.let {
////            val descriptionText = vPostDesc.text.toString()
//            PostDatabase(
//                id = getDataPost.id,
//                name = vPostTitle.text.toString(),
//                description = vPostDesc.text.toString(),
//                image = imageFile,
//                like = getDataPost.like
//            )
//        }

        post?.let { postViewModel.updatePost(it) }

        Toast.makeText(
            this@UpdatePostRoomActivity,
            "Data Success Updated",
            Toast.LENGTH_SHORT
        ).show()

        finish()
    }


    fun toMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

