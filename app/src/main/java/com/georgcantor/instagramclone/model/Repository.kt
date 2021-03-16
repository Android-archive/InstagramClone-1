package com.georgcantor.instagramclone.model

class Repository(private val service: ApiService) {

    suspend fun getPictures(query: String) = service.getPictures(query, 1)
}