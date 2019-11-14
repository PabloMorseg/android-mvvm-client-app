package com.udemy.my_songs.ui.main_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.udemy.my_songs.model.Repository
import kotlinx.coroutines.Dispatchers

class SongsListViewModel(repository: Repository) : ViewModel() {

    var songsLiveData = liveData(Dispatchers.IO) {
        val songs = repository.retrieveSongs()
        emit(songs)
    }
}
