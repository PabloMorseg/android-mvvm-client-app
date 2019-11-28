package com.udemy.my_songs.ui.main_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.udemy.my_songs.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SongsListViewModel(private val repository: Repository) : ViewModel() {

    private val tag = "SongsListViewModel"

    var songsLiveData = liveData(Dispatchers.IO) {
        try {
            val songs = repository.retrieveSongs()
            emit(songs)
        } catch (exception: Exception) {
            Log.e(tag, "Error loading songs: ${exception.message}")
        }
    }

    fun removeSong(songId: String) {
        viewModelScope.launch {
            try {
                repository.removeSong(songId)
            } catch (exception: Exception) {
                Log.e(tag, "Error removing song: ${exception.message}")
            }
        }
    }
}
