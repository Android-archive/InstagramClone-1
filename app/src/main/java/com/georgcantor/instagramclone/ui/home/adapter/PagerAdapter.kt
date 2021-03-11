package com.georgcantor.instagramclone.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.georgcantor.instagramclone.R
import com.georgcantor.instagramclone.util.loadImage

class PagerAdapter(private val urls: List<String>) :
    RecyclerView.Adapter<PagerAdapter.PagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_pager, parent, false)
    )

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.itemView.context.loadImage(urls[position], holder.image)
    }

    override fun getItemCount() = urls.size

    class PagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
    }
}