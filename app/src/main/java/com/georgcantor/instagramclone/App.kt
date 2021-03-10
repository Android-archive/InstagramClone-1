package com.georgcantor.instagramclone

import android.app.Application
import com.georgcantor.instagramclone.di.apiModule
import com.georgcantor.instagramclone.di.repositoryModule
import com.georgcantor.instagramclone.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(apiModule, repositoryModule, viewModelModule))
        }
    }
}