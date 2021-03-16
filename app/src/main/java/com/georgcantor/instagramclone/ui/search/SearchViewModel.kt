package com.georgcantor.instagramclone.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.georgcantor.instagramclone.model.Repository
import com.georgcantor.instagramclone.model.response.Hit
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class SearchViewModel(repository: Repository) : ViewModel() {

    val pictures = MutableLiveData<List<Hit>>()
    val error = MutableLiveData<String>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        error.postValue(throwable.message)
    }

    init {
        viewModelScope.launch(exceptionHandler) {
            repository.getPictures("sea").apply {
                if (isSuccessful) pictures.postValue(body()?.hits)
            }
        }
    }
}