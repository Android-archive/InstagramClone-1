package com.georgcantor.instagramclone.util

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.widget.ImageView
import com.bumptech.glide.Glide

fun Context.isNetworkAvailable() = (getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?)
    ?.activeNetworkInfo?.isConnectedOrConnecting ?: false

fun Context.loadImage(url: String?, imageView: ImageView) = Glide.with(this)
    .load(url)
    .into(imageView)

fun Context.loadCircleImage(url: String?, imageView: ImageView) = Glide.with(this)
    .load(url)
    .circleCrop()
    .into(imageView)