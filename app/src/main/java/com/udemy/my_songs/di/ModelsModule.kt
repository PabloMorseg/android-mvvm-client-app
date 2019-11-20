package com.udemy.my_songs.di

import com.udemy.my_songs.model.Repository
import com.udemy.my_songs.ui.add_song.AddSongViewModel
import com.udemy.my_songs.ui.main_list.SongsListFragment
import com.udemy.my_songs.ui.main_list.SongsListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modelsModule = module {
    single { Repository(get()) }

    viewModel { SongsListViewModel(get()) }
    viewModel { AddSongViewModel(get()) }
    factory { SongsListFragment() }
}