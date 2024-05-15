package com.vinz.latihanrecyclerview1.adapter;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vinz.latihanrecyclerview1.R
import com.vinz.latihanrecyclerview1.data.PlayerData
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class AdapterHori(private val playerList: ArrayList<PlayerData>) : RecyclerView.Adapter<AdapterHori.PlayerViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: PlayerData)
    }

    inner class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nama: MaterialTextView = itemView.findViewById(R.id.player_name)
        val tempat: MaterialTextView = itemView.findViewById(R.id.player_description)
        val image: ShapeableImageView = itemView.findViewById(R.id.player_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_player_horizontal, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = playerList[position]

        holder.nama.text = player.nama
        holder.tempat.text = player.tempat.shorten(85)
        holder.image.setImageResource(player.image)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(player)
        }
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}

