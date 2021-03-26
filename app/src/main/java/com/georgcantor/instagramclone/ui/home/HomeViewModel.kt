package com.georgcantor.instagramclone.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.georgcantor.instagramclone.model.PicPagingSource
import com.georgcantor.instagramclone.model.Repository
import com.georgcantor.instagramclone.model.response.Picture
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {

    val pictures = MutableLiveData<List<Picture>>()
    val error = MutableLiveData<String>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        error.postValue(throwable.message)
    }

    init {
        viewModelScope.launch(exceptionHandler) {
            repository.getPictures("art", 1).apply {
                if (isSuccessful) pictures.postValue(body()?.hits)
            }
        }
    }

    fun getPictures(): Flow<PagingData<Picture>> {
        return Pager(PagingConfig(30)) {
            PicPagingSource(repository, "sky")
        }.flow
    }
}