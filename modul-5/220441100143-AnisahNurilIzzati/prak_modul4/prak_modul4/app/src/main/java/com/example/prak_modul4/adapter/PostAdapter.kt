package com.example.prak_modul4.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prak_modul4.R
import com.example.prak_modul4.room.PostDatabase
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

// Kelas PeopleAdapterRoom adalah kelas yang bertugas untuk mengatur tampilan data orang pada RecyclerView.
// Kelas ini menerima daftar post sebagai parameter konstruktor dan mewarisi RecyclerView.Adapter.

class PostAdapter(private var postList: List<PostDatabase>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    // Deklarasi variabel onItemClickCallback yang akan digunakan untuk menangani klik pada item RecyclerView.
    private lateinit var onItemClickCallback: OnItemClickCallback
    // Map untuk menyimpan status suka dari setiap item
    private val likedStatus = mutableMapOf<Int, Boolean>()

    // Fungsi setOnItemClickCallback digunakan untuk mengatur callback untuk klik item.
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Interface OnItemClickCallback digunakan untuk mendefinisikan metode callback yang akan dipanggil ketika item diklik.
    interface OnItemClickCallback {
//        fun onItemClicked(data: PostDatabase)
        fun onItemMore(data: PostDatabase)
    }

    // Kelas PlayerViewHolder adalah kelas yang bertugas untuk menyimpan referensi ke tampilan item pada RecyclerView.
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postTitle: TextView = itemView.findViewById(R.id.post_title)
        val postDesc: TextView = itemView.findViewById(R.id.post_desc)
        val postImg: ShapeableImageView = itemView.findViewById(R.id.post_img)
        val postLike: TextView = itemView.findViewById(R.id.post_like)
        val btnLike: ImageView = itemView.findViewById(R.id.btn_like)
        val btnMore: ImageView = itemView.findViewById(R.id.btn_more)
    }

    // Fungsi onCreateViewHolder digunakan untuk membuat ViewHolder baru untuk item RecyclerView.
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }


    // Fungsi onBindViewHolder digunakan untuk mengatur tampilan item pada RecyclerView berdasarkan data orang.
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val data = postList[position]

        holder.postTitle.text = data.name
        holder.postDesc.text = data.description.shorten(500)
        holder.postLike.text = data.like.toString()
//        holder.postDate.text = data.waktu

        // Mengatur image
        val uri = Uri.fromFile(data.image)
        holder.postImg.setImageURI(uri)

        // Menetapkan onClickListener pada itemView untuk memanggil callback ketika item diklik.
//        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(postList[holder.absoluteAdapterPosition]) }

        holder.btnMore.setOnClickListener { onItemClickCallback.onItemMore(postList[holder.absoluteAdapterPosition]) }

        holder.btnLike.setOnClickListener {
            val newLikedStatus = !(likedStatus[position] ?: false)
            likedStatus[position] = newLikedStatus

            if (newLikedStatus) {
                holder.btnLike.setImageResource(R.drawable.baseline_favorite_24)
                data.like += 1
            } else {
                holder.btnLike.setImageResource(R.drawable.outline_favorite_border_24)
                data.like -= 1
            }

            holder.postLike.text = data.like.toString()
        }
    }

    // Fungsi getItemCount digunakan untuk mendapatkan jumlah item pada RecyclerView.
    override fun getItemCount(): Int = postList.size


    fun updatePosts(posts: List<PostDatabase>) {
        postList = posts
        notifyDataSetChanged()
    }
    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}