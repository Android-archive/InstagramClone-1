package com.georgcantor.instagramclone.model

class Repository(private val service: ApiService) {

    suspend fun getPictures(query: String, index: Int) = service.getPictures(query, index)
}