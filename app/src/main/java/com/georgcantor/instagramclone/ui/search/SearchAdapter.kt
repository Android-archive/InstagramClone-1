package com.georgcantor.instagramclone.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.georgcantor.instagramclone.R
import com.georgcantor.instagramclone.model.response.Hit
import com.georgcantor.instagramclone.util.loadImage

class SearchAdapter(
    private val pictures: List<Hit>
) : ListAdapter<Hit, SearchAdapter.SearchHolder>(ItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
    )

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        holder.itemView.context.loadImage(pictures[position].webformatURL, holder.image)
    }

    class SearchHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
    }

    override fun getItemCount() = pictures.size

    class ItemDiffCallback : DiffUtil.ItemCallback<Hit>() {
        override fun areItemsTheSame(old: Hit, new: Hit) = old == new
        override fun areContentsTheSame(old: Hit, new: Hit) = old.id == new.id
    }
}