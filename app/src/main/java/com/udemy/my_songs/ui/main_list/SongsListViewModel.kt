package com.udemy.my_songs.ui.main_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.udemy.my_songs.model.Repository
import kotlinx.coroutines.Dispatchers

class SongsListViewModel(repository: Repository) : ViewModel() {

    var songsLiveData = liveData(Dispatchers.IO) {
        try {
            val songs = repository.retrieveSongs()
            emit(songs)
        } catch (exception: Exception) {
            Log.e("SongsListViewModel", "Error loading songs: ${exception.message}")
        }
    }
}
