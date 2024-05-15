package com.vinz.latihanrecyclerview1.adapter

import androidx.recyclerview.widget.RecyclerView
import com.vinz.latihanrecyclerview1.data.PlayerDataVertical
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.imageview.ShapeableImageView
import com.vinz.latihanrecyclerview1.R


// Kelas adapter untuk RecyclerView dengan tampilan GridLayoutManager
class AdapterVertical(private val verlist: List<PlayerDataVertical>) : RecyclerView.Adapter<AdapterVertical.PlayerViewHolder>() {

    // Deklarasi variabel untuk callback ketika item diklik
    private lateinit var onItemClickCallback: OnItemClickCallback

    // Fungsi untuk mengatur callback ketika item diklik
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Interface untuk callback ketika item diklik
    interface OnItemClickCallback {
        fun onItemClicked(data: PlayerDataVertical)
    }

    // Kelas ViewHolder untuk menyimpan referensi view yang digunakan dalam RecyclerView
    class PlayerViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tempat: TextView = itemView.findViewById(R.id.player_name)
        val pengunjung: TextView = itemView.findViewById(R.id.playerpengunjung)
        val rating: TextView = itemView.findViewById(R.id.player_rating)
        val image: ShapeableImageView = itemView.findViewById(R.id.player_image)
    }

    // Fungsi untuk membuat ViewHolder (Melakukan setting untuk XML yang akan kita gunakan untuk menampilkan data)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_player_grid, parent, false)
        return PlayerViewHolder(view)
    }

    // Fungsi untuk mengikat data dengan ViewHolder (memasukkan data yang kita miliki ke dalam XML ViewHolder)
    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val data = verlist[position]

        holder.tempat.text = data.tempat
        holder.pengunjung.text = data.pengunjung.toString()
        holder.rating.text = data.rating.toString()
        holder.image.setImageResource(data.image)

        // Mengatur aksi ketika item diklik
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(verlist[holder.adapterPosition]) }
    }

    // Fungsi untuk mendapatkan jumlah item
    override fun getItemCount(): Int = verlist.size

    // Fungsi untuk memendekkan teks jika melebihi panjang maksimum
    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}