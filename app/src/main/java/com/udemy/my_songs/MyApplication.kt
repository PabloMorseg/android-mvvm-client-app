package com.udemy.my_songs

import android.app.Application
import com.udemy.my_songs.di.modelsModule
import com.udemy.my_songs.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(modelsModule, networkModule))
        }
    }
}