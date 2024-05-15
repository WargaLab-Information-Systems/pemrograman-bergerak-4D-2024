package com.vinz.latihanrecyclerview1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vinz.latihanrecyclerview1.adapter.AdapterVertical
import com.vinz.latihanrecyclerview1.adapter.AdapterHori
import com.vinz.latihanrecyclerview1.data.PlayerDataList
import com.vinz.latihanrecyclerview1.data.PlayerData
import com.vinz.latihanrecyclerview1.data.PlayerDataVertical
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {
    // Deklarasi variabel untuk adapter dan RecyclerView
    private lateinit var adapterverti: AdapterVertical
    private lateinit var adapterhori: AdapterHori
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerviewHorizontal: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mengambil data nama dari intent
        val getDataName = intent.getStringExtra("Nama")

        // Menampilkan teks sapaan dengan nama pengguna
        val displayTitle = findViewById<MaterialTextView>(R.id.greeting_text)
        displayTitle.text = "Hi, $getDataName"


        // Menghubungkan variabel dengan komponen di layout
        recyclerView = findViewById(R.id.rv_player)
        recyclerviewHorizontal = findViewById(R.id.rv_player_horizontal)

        // Menginisialisasi semua adapter dengan data
        adapterhori = AdapterHori(PlayerDataList.horiDum)
        adapterverti = AdapterVertical(PlayerDataList.veriveri)


        // Menampilkan RecyclerView
        showRecyclerList()
    }

    // Fungsi untuk menampilkan RecyclerView Default
    private fun showRecyclerList() {
        // Mengatur layoutManager dan adapter untuk RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapterhori

        // Mengatur layoutManager dan adapter untuk RecyclerView horizontal
        recyclerviewHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerviewHorizontal.adapter = adapterverti

        // Menetapkan aksi ketika item di RecyclerView diklik
        adapterhori.setOnItemClickCallback(object : AdapterHori.OnItemClickCallback {
            override fun onItemClicked(data: PlayerData) {
                showSelectedLocation(data)
            }
        })

        adapterverti.setOnItemClickCallback(object : AdapterVertical.OnItemClickCallback {
            override fun onItemClicked(data: PlayerDataVertical) {
                showSelectedHotel(data)
            }
        })

    }

    // Fungsi untuk menampilkan detail pemain yang dipilih
    private fun showSelectedLocation(data: PlayerData) {
//         Membuat intent untuk berpindah ke DetailPlayerActivity
        val navigateToDetail = Intent(this, DetailPlayerActivity::class.java)

        // Menambahkan dan membawa data pemain ke intent dengan tujuan ke DetailPlayerActivity
        navigateToDetail.putExtra("name", data.nama)
        navigateToDetail.putExtra("lokasi", data.tempat)
        navigateToDetail.putExtra("image", data.image)
        navigateToDetail.putExtra("description", data.deskripsi)

        // Memulai activity baru
        startActivity(navigateToDetail)
    }

    // Fungsi untuk menampilkan detail pemain yang dipilih
    private fun showSelectedHotel(data: PlayerDataVertical) {
        // Membuat intent untuk berpindah ke DetailPlayerActivity
        val navigateToDetail = Intent(this, DetailPlayerActivity::class.java)

        // Menambahkan dan membawa data pemain ke intent dengan tujuan ke DetailPlayerActivity
        navigateToDetail.putExtra("name", data.tempat)
        navigateToDetail.putExtra("description", data.deskripsi)
        navigateToDetail.putExtra("image", data.image)


        // Memulai activity baru
        startActivity(navigateToDetail)
    }

}
