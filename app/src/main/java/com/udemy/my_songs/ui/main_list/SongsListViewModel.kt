package com.udemy.my_songs.ui.main_list

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

class SongsListViewModel(private val repository: Repository) : ViewModel() {

    private val tag = "SongsListViewModel"

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
        refreshSongs()
    }

    fun getSongs(): LiveData<List<Song>> = songs

    fun refreshSongs() {
        reloadTrigger.value = true
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
