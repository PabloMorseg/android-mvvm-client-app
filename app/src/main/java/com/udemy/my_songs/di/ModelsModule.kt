package com.udemy.my_songs.di

import com.udemy.my_songs.model.Repository
import com.udemy.my_songs.ui.SongsListFragment
import com.udemy.my_songs.ui.SongsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modelsModule = module {
    single { Repository(get()) }

    viewModel { SongsViewModel(get()) }
    factory { SongsListFragment() }
}