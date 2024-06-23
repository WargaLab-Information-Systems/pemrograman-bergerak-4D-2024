package com.avrzll.implementasi6

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avrzll.implementasi6.adapter.PlayerAdapter
import com.avrzll.implementasi6.data.remote.PlayerData
import com.avrzll.implementasi6.data.remote.PlayerViewModel
import com.avrzll.implementasi6.data.remote.PlayerViewModelFactory
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import java.time.LocalTime

class MainActivity : AppCompatActivity() {
    private lateinit var playerViewModel: PlayerViewModel
    private lateinit var adapter: PlayerAdapter
    private lateinit var recyclerView: RecyclerView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jambukaapk = LocalTime.now()
        val earlyMorning = LocalTime.of(5, 0)
        val noon = LocalTime.of(12, 0)
        val evening = LocalTime.of(18, 0)
        val night = LocalTime.of(23, 59) // Representing midnight

        val greetingtext = findViewById<TextView>(R.id.greetingtext)

        when {
            jambukaapk.isBefore(earlyMorning) -> {
                greetingtext.text = "Selamat Subuh"
            }
            jambukaapk.isBefore(noon) -> {
                greetingtext.text = "Selamat Pagi"
            }
            jambukaapk.isBefore(evening) -> {
                greetingtext.text = "Selamat Siang"
            }
            jambukaapk.isBefore(night) -> {
                greetingtext.text = "Selamat Malam "
            }
            else -> {
                // Optional: handle the case for exactly midnight if needed
                greetingtext.text = "Selamat Malam"
            }
        }

        val imageProfile = findViewById<ShapeableImageView>(R.id.imageProfile)
        imageProfile.setOnClickListener {
            val intent = Intent(this, AuthorActivity::class.java)
            startActivity(intent)
        }

        val factory = PlayerViewModelFactory.getInstance()
        playerViewModel = ViewModelProvider(this,
            factory)[PlayerViewModel::class.java]
        recyclerView = findViewById(R.id.rvPlayer)
        recyclerView.layoutManager = LinearLayoutManager(this)
        playerViewModel.getAllPlayer()
        playerViewModel.listPlayer.observe(this) { players ->
            if (players.isNotEmpty()) {
                adapter = PlayerAdapter(players)
                recyclerView.adapter = adapter
                adapter.setOnItemClickCallback(object :
                    PlayerAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: PlayerData) {
                        showSelectedPlayer(data)
                    }
                })
            }
        }

    }

    private fun showSelectedPlayer(data: PlayerData) {
        val navigateToDetail = Intent(this, DetailPlayerActivity::class.java)
        navigateToDetail.putExtra("players", data)
        startActivity(navigateToDetail)
    }
}