package com.georgcantor.instagramclone.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.georgcantor.instagramclone.model.Repository
import com.georgcantor.instagramclone.model.response.Hit
import kotlinx.coroutines.launch

class HomeViewModel(repository: Repository) : ViewModel() {

    val pictures = MutableLiveData<List<Hit>>()

    init {
        viewModelScope.launch {
            repository.getPictures().apply {
                if (isSuccessful) pictures.postValue(body()?.hits)
            }
        }
    }
}