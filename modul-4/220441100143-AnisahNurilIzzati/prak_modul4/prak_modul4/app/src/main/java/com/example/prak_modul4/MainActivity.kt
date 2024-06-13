package com.example.prak_modul4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prak_modul4.activity.AddPostRoomActivity
import com.example.prak_modul4.activity.PopUpFragment
import com.example.prak_modul4.activity.UpdatePostRoomActivity
import com.example.prak_modul4.adapter.PostAdapter
import com.example.prak_modul4.room.PostDatabase
import com.example.prak_modul4.room.PostViewModel
import com.example.prak_modul4.room.PostViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var postViewModel: PostViewModel
    private lateinit var postAdapterRoom: PostAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = PostViewModelFactory.getInstance(this)
        postViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]
        recyclerView = findViewById(R.id.rv_post)
        recyclerView.layoutManager = LinearLayoutManager(this)

        postViewModel.getAllPost().observe(this) { postData ->
            if (postData != null) {
                postAdapterRoom = PostAdapter(postData) //ini
                recyclerView.adapter = postAdapterRoom

                // Menangani aksi klik pada item di RecyclerView.
                postAdapterRoom.setOnItemClickCallback(object : PostAdapter.OnItemClickCallback {
//                    override fun onItemClicked(data: PostDatabase) {
//                        showSelectedPeople(data)
//                    }

                    override fun onItemMore(data: PostDatabase) {
                        PopUpFragment(data).show(supportFragmentManager, PopUpFragment.TAG)
                    }
                })
            }
        }
    }

    // Fungsi untuk menampilkan detail orang yang dipilih.
//    private fun showSelectedPeople(data: PostDatabase) {
//         Membuat intent untuk berpindah ke DetailPeopleActivity.
//        val navigateToDetail = Intent(this, UpdatePostRoomActivity::class.java)
//
//        // Menambahkan dan membawa data orang ke intent dengan tujuan ke DetailPeopleActivity.
//        navigateToDetail.putExtra("post", data)
//
//        // Memulai activity baru.
//        startActivity(navigateToDetail)
//    }

    override fun onRestart() {
        super.onRestart()
        postViewModel.getAllPost()
    }


    fun toAddPost(view: View) {
        val intent = Intent(this, AddPostRoomActivity::class.java)
        startActivity(intent)
    }

}