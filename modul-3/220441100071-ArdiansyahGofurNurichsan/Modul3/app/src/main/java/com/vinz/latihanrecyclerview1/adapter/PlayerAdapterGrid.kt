package com.vinz.latihanrecyclerview1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import com.vinz.latihanrecyclerview1.R
import com.vinz.latihanrecyclerview1.data.DataHotel

// Kelas adapter untuk RecyclerView dengan tampilan GridLayoutManager
class PlayerAdapterGrid(private val playerList: List<DataHotel>) : RecyclerView.Adapter<PlayerAdapterGrid.PlayerViewHolder>() {

    // Deklarasi variabel untuk callback ketika item diklik
    private lateinit var onItemClickCallback: OnItemClickCallback

    // Fungsi untuk mengatur callback ketika item diklik
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Interface untuk callback ketika item diklik
    interface OnItemClickCallback {
        fun onItemClicked(data: DataHotel)
    }

    // Kelas ViewHolder untuk menyimpan referensi view yang digunakan dalam RecyclerView
    class PlayerViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: MaterialTextView = itemView.findViewById(R.id.hotel_name)
        val image: ShapeableImageView = itemView.findViewById(R.id.hotel_image)
        val org : ShapeableImageView = itemView.findViewById(R.id.org)
        val textOrg : MaterialTextView = itemView.findViewById(R.id.text_org)
        val bintang : ShapeableImageView = itemView.findViewById(R.id.bintang)
        val textBintang : MaterialTextView = itemView.findViewById(R.id.text_bintang)
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
        val data = playerList[position]

        holder.name.text = data.name
        holder.image.setImageResource(data.image)
        holder.org.setImageResource(data.org)
        holder.textOrg.text = data.textOrg
        holder.bintang.setImageResource(data.bintang)
        holder.textBintang.text = data.textBintang

        // Mengatur aksi ketika item diklik
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(playerList[holder.adapterPosition]) }
    }

    // Fungsi untuk mendapatkan jumlah item
    override fun getItemCount(): Int = playerList.size

    // Fungsi untuk memendekkan teks jika melebihi panjang maksimum
    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}