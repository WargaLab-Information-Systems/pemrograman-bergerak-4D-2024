package com.example.prak_modul6.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prak_modul6.R
import com.example.prak_modul6.adapter.PlayerAdapter
import com.example.prak_modul6.remote.PlayerData
import com.example.prak_modul6.remote.ViewModelFactory
import com.example.prak_modul6.remote.ViewModelPlayer

import com.google.android.material.imageview.ShapeableImageView

class MainActivity : AppCompatActivity() {
    private lateinit var viewModelPlayer: ViewModelPlayer
    private lateinit var adapter: PlayerAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageProfile = findViewById<ShapeableImageView>(R.id.imageProfile)
        imageProfile.setOnClickListener {
            val intent = Intent(this, CreatorActivity::class.java)
            startActivity(intent)
        }

        val factory = ViewModelFactory.getInstance()
        viewModelPlayer = ViewModelProvider(this, factory)[ViewModelPlayer::class.java]
        recyclerView = findViewById(R.id.rvPlayer)
        recyclerView.layoutManager = LinearLayoutManager(this)
        viewModelPlayer.getAllPlayer()
        viewModelPlayer.listPlayer.observe(this) { players ->
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