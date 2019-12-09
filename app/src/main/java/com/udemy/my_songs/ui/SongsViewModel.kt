package com.udemy.my_songs.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.udemy.my_songs.model.Repository
import com.udemy.my_songs.model.Song
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SongsViewModel(private val repository: Repository) : ViewModel() {

    private val tag = "SongsListViewModel"
    private var songsNeedRefresh = false

    private val reloadTrigger = MutableLiveData<Boolean>()
    private val songs: LiveData<List<Song>> = Transformations.switchMap(reloadTrigger) {
        liveData(Dispatchers.IO) {
            try {
                val songs = repository.retrieveSongs()
                emit(songs)
            } catch (exception: Exception) {
                Log.e(tag, "Error loading songs: ${exception.message}")
            }
        }
    }

    init {
        refreshSongs(true)
    }

    fun getSongs(): LiveData<List<Song>> = songs

    fun refreshSongs(forceUpdate: Boolean) {
        if (forceUpdate || songsNeedRefresh) {
            reloadTrigger.value = true
        }
    }

    fun createSong(song: Song) {
        viewModelScope.launch {
            try {
                repository.createSong(song)
                songsNeedRefresh = true
            } catch (exception: Exception) {
                Log.e(tag, "Error creating song: ${exception.message}")
            }
        }
    }

    fun updateSong(song: Song) {
        viewModelScope.launch {
            try {
                repository.updateSong(song)
                songsNeedRefresh = true
            } catch (exception: Exception) {
                Log.e(tag, "Error updating song: ${exception.message}")
            }
        }
    }

    fun removeSong(songId: String) {
        viewModelScope.launch {
            try {
                repository.removeSong(songId)
                songsNeedRefresh = true
            } catch (exception: Exception) {
                Log.e(tag, "Error removing song: ${exception.message}")
            }
        }
    }
}
