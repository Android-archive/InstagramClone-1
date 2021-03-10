package com.georgcantor.instagramclone.di

import com.georgcantor.instagramclone.model.ApiClient
import com.georgcantor.instagramclone.model.Repository
import org.koin.dsl.module

val apiModule = module { single { ApiClient.create(get()) } }

val repositoryModule = module { single { Repository(get()) } }

val viewModelModule = module(override = true) {
//    viewModel { MainViewModel(get()) }
}