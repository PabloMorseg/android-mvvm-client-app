package com.udemy.my_songs.ui.main_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.udemy.my_songs.model.Repository
import com.udemy.my_songs.model.Song

class SongsListViewModel : ViewModel() {

    private var repository = Repository()

    val allSongs: LiveData<List<Song>>
        get() = _songsList
    private val _songsList: LiveData<List<Song>> = repository.getAllSongs()
}
