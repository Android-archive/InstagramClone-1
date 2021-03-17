package com.georgcantor.instagramclone.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.georgcantor.instagramclone.R
import com.georgcantor.instagramclone.model.response.Picture
import com.georgcantor.instagramclone.util.loadCircleImage

class HeaderAdapter(private val pictures: List<Picture>) : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HeaderViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
    )

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        val picture = pictures[position]
        holder.itemView.context.loadCircleImage(picture.userImageURL, holder.image)
        holder.name.text = picture.user
    }

    override fun getItemCount() = pictures.size

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.circle_image)
        val name: TextView = view.findViewById(R.id.name)
    }
}