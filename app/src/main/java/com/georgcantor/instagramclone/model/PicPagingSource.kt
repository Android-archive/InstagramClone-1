package com.georgcantor.instagramclone.model

import androidx.paging.PagingSource
import com.georgcantor.instagramclone.model.response.Hit

class PicPagingSource(
    private val repository: Repository,
    private val query: String
) : PagingSource<Int, Hit>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hit> {
        return try {
            val nextPage = params.key ?: 1
            val response = repository.getPictures(query, nextPage)
            LoadResult.Page(
                response.body()?.hits ?: emptyList(),
                if (nextPage == 1) null else nextPage - 1,
                if (nextPage < response.body()?.hits?.size ?: 0) nextPage + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}