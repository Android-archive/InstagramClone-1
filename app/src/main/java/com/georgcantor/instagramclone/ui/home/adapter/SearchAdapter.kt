package com.georgcantor.instagramclone.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.georgcantor.instagramclone.databinding.ItemFeedBinding
import com.georgcantor.instagramclone.model.response.Picture
import com.georgcantor.instagramclone.util.loadCircleImage

class SearchAdapter(
    private val clickListener: (Picture?) -> Unit
) : PagingDataAdapter<Picture, RecyclerView.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GalleryViewHolder(
        ItemFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pic = getItem(position)
        val images = listOf(pic?.webformatURL, pic?.webformatURL, pic?.webformatURL)

        with(holder as GalleryViewHolder) {
            itemView.context.loadCircleImage(pic?.userImageURL, binding.icon)
            binding.name.text = pic?.user
            binding.pagerIndices.text = "${binding.viewPager.currentItem}/${images.size}"
            binding.viewPager.adapter = PagerAdapter(images as List<String>)
            binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    binding.pagerIndices.text = "${position + 1}/${images.size}"
                    super.onPageSelected(position)
                }
            })

            itemView.setOnClickListener { clickListener(pic) }
        }
    }

    class GalleryViewHolder(val binding: ItemFeedBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        object DiffCallback : DiffUtil.ItemCallback<Picture>() {
            override fun areItemsTheSame(old: Picture, new: Picture) = old == new

            override fun areContentsTheSame(old: Picture, new: Picture) = old.id == new.id
        }
    }
}