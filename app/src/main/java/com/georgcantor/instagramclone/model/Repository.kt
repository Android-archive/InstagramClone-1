package com.georgcantor.instagramclone.model

import com.georgcantor.instagramclone.model.api.ApiService

class Repository(private val service: ApiService) {

    suspend fun getPictures(query: String, index: Int) = service.getPictures(query, index)
}