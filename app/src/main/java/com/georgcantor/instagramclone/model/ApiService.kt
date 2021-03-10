package com.georgcantor.instagramclone.model

import com.georgcantor.instagramclone.BuildConfig.PIXABAY_KEY
import com.georgcantor.instagramclone.model.response.Pic
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("?key=$PIXABAY_KEY")
    suspend fun getPixabayPictures(
        @Query("q") query: String,
        @Query("page") index: Int
    ): Response<Pic>
}