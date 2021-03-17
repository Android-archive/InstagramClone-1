package com.georgcantor.instagramclone.ui.search

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.georgcantor.instagramclone.model.PicPagingSource
import com.georgcantor.instagramclone.model.Repository
import com.georgcantor.instagramclone.model.response.Picture
import kotlinx.coroutines.flow.Flow

class SearchViewModel(private val repository: Repository) : ViewModel() {

    fun getPictures(): Flow<PagingData<Picture>> {
        return Pager(PagingConfig(20)) {
            PicPagingSource(repository, "sea")
        }.flow
    }
}