package com.example.prak_modul4.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prak_modul4.R
import com.example.prak_modul4.adapter.PostAdapter
import com.example.prak_modul4.room.PostDatabase
import com.example.prak_modul4.room.PostViewModel
import com.example.prak_modul4.room.PostViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

//class PostRoomActivity : AppCompatActivity() {
//
//    // Mendeklarasikan ViewModel untuk interaksi dengan database
//    // ViewModel digunakan untuk menyimpan dan mengelola data yang terkait dengan UI.
//    private lateinit var postViewModel: PostViewModel
//
//    // Mendeklarasikan adapter untuk RecyclerView.
//    // Adapter digunakan untuk mengatur bagaimana item dalam RecyclerView ditampilkan.
//    private lateinit var postAdapter: PostAdapter
//
//    // Mendeklarasikan RecyclerView untuk menampilkan daftar pemain.
//    // RecyclerView adalah komponen UI yang digunakan untuk menampilkan daftar item dalam format yang dapat digulir.
//    private lateinit var recyclerView: RecyclerView
//
//    // Fungsi onCreate dipanggil ketika activity dibuat.
//    // Fungsi ini digunakan untuk melakukan inisialisasi awal untuk activity.
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // Mendapatkan instance ViewModel.
//        // ViewModelProvider digunakan untuk membuat ViewModel.
//        val factory = PostViewModelFactory.getInstance(this)
//        postViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]
//
//        // Menghubungkan variabel dengan komponen di layout.
//        // findViewById digunakan untuk mendapatkan referensi ke komponen di layout berdasarkan ID-nya.
//        recyclerView = findViewById(R.id.rv_post)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        // Mengamati perubahan data pemain dan memperbarui RecyclerView.
//        // LiveData digunakan untuk mengamati perubahan data dalam database dan secara otomatis memperbarui UI jika ada perubahan.
//        postViewModel.getAllPost().observe(this) { postData ->
//            if (postData != null) {
//                postAdapter = PostAdapter(postData)
//                recyclerView.adapter = postAdapter
//
//                // Menangani aksi klik pada item di RecyclerView.
//                postAdapter.setOnItemClickCallback(object :
//                    PostAdapter.OnItemClickCallback {
//                    override fun onItemClicked(data: PostDatabase) {
//                        showSelectedPlayer(data)
//                    }
//
//                    override fun onMoreClicked(data: PostDatabase, position: Int) {
//                        PopUpFragment(data, position).show(supportFragmentManager, PopUpFragment.TAG)
//                    }
//                })
//            }
//        }
//
//        // Menangani aksi klik pada tombol tambah pemain.
//        val btnAdd = findViewById<FloatingActionButton>(R.id.btn_addPost)
//        btnAdd.setOnClickListener {
//            val intent = Intent(this, AddPostRoomActivity::class.java)
//            startActivity(intent)
//        }
//
//        // Menangani aksi klik pada tombol navigasi.
//        val btnMore = findViewById<ImageView>(R.id.btn_more)
//        btnMore.setOnClickListener {
//            val intent = Intent(this, UpdatePostRoomActivity::class.java)
//            startActivity(intent)
//        }
//    }
//
//    // Fungsi untuk menampilkan detail pemain yang dipilih.
////    private fun showSelectedPlayer(data: PostDatabase) {
////        val navigateToDetail = Intent(this, DetailPlayerActivity::class.java)
////
////        navigateToDetail.putExtra("player", data)
////
////        startActivity(navigateToDetail)
////    }
//
//    // Fungsi onRestart dipanggil ketika activity dimulai kembali setelah berhenti.
//    // Fungsi ini digunakan untuk melakukan pembaruan data atau UI yang diperlukan.
//    override fun onRestart() {
//        super.onRestart()
//
//        postViewModel.getAllPost()
//    }
//
//    // Fungsi onResume dipanggil ketika activity mulai berinteraksi dengan pengguna.
//    // Fungsi ini digunakan untuk melakukan pembaruan data atau UI yang diperlukan.
//    override fun onResume() {
//        super.onResume()
//
//        postViewModel.getAllPost()
//    }
//
//}