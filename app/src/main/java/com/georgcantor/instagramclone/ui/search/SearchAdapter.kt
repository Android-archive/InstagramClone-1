package com.georgcantor.instagramclone.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.georgcantor.instagramclone.databinding.ItemSearchBinding
import com.georgcantor.instagramclone.model.response.Picture
import com.georgcantor.instagramclone.util.loadImage

class SearchAdapter(
    private val clickListener: (Picture?) -> Unit
) : PagingDataAdapter<Picture, RecyclerView.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GalleryViewHolder(
        ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val picture = getItem(position)
        (holder as GalleryViewHolder).apply {
            picture?.webformatURL?.let { itemView.context.loadImage(it, binding.image) }
            itemView.setOnClickListener { clickListener(picture) }
        }
    }

    class GalleryViewHolder(val binding: ItemSearchBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        object DiffCallback : DiffUtil.ItemCallback<Picture>() {
            override fun areItemsTheSame(old: Picture, new: Picture) = old == new

            override fun areContentsTheSame(old: Picture, new: Picture) = old.id == new.id
        }
    }
}