package com.georgcantor.instagramclone.di

import com.georgcantor.instagramclone.model.Repository
import com.georgcantor.instagramclone.model.api.ApiClient
import com.georgcantor.instagramclone.ui.home.HomeViewModel
import com.georgcantor.instagramclone.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val apiModule = module { single { ApiClient.create(get()) } }

val repositoryModule = module { single { Repository(get()) } }

val viewModelModule = module(override = true) {
    viewModel { HomeViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}