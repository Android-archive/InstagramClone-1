package com.georgcantor.instagramclone.model

class Repository(private val service: ApiService) {

    suspend fun getPictures() = service.getPictures("art", 1)
}