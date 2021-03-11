package com.georgcantor.instagramclone.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.georgcantor.instagramclone.R
import com.georgcantor.instagramclone.model.response.Hit
import com.georgcantor.instagramclone.util.loadCircleImage

class FeedAdapter(private val pictures: List<Hit>) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FeedViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)
    )

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val picture = pictures[position]
        with(holder) {
            itemView.context.loadCircleImage(picture.userImageURL, icon)
            name.text = picture.user
            viewPager.adapter = PagerAdapter(listOf(picture.webformatURL, picture.webformatURL))
        }
    }

    override fun getItemCount() = pictures.size

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.icon)
        val name: TextView = view.findViewById(R.id.name)
        val viewPager: ViewPager2 = view.findViewById(R.id.view_pager)
    }
}