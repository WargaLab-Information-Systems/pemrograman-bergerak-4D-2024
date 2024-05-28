package com.example.m4.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m4.R
import com.example.m4.room.PostDatabase
import com.google.android.material.imageview.ShapeableImageView

class PostAdapterRoom(private var postList: List<PostDatabase>) :
    RecyclerView.Adapter<PostAdapterRoom.PostViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    private val likedStatus = mutableMapOf<Int, Boolean>()

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: PostDatabase)
        fun onItemLain(data: PostDatabase)
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postDesc: TextView = itemView.findViewById(R.id.id_content)
        val postImg: ShapeableImageView = itemView.findViewById(R.id.id_post)
        val postLike: TextView = itemView.findViewById(R.id.text_love)
        val postDate: TextView = itemView.findViewById(R.id.text_komen)
        val btnMore: ImageView = itemView.findViewById(R.id.id_komen)

        val btnLike: ImageView = itemView.findViewById(R.id.id_love)
        val btnLain: ImageView = itemView.findViewById(R.id.id_more)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val data = postList[position]

        holder.postDesc.text = data.description.shorten(500)
        holder.postLike.text = data.like.toString()

        val uri = Uri.fromFile(data.image)
        holder.postImg.setImageURI(uri)

        holder.btnLain.setOnClickListener { onItemClickCallback.onItemLain(postList[holder.absoluteAdapterPosition]) }

        holder.btnLike.setOnClickListener {
            val newLikedStatus = !(likedStatus[position] ?: false)
            likedStatus[position] = newLikedStatus

            if (newLikedStatus) {
                holder.btnLike.setImageResource(R.drawable.baseline_favorite_24)
                data.like += 1
            } else {
                holder.btnLike.setImageResource(R.drawable.love)
                data.like -= 1
            }

            holder.postLike.text = data.like.toString()
        }

        holder.btnMore.setOnClickListener { onItemClickCallback.onItemClicked(postList[holder.adapterPosition]) }
    }

    fun updatePosts(posts: List<PostDatabase>) {
        postList = posts
        notifyDataSetChanged()
    }

    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}
