package com.udemy.my_songs.ui.add_song

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udemy.my_songs.model.Repository
import com.udemy.my_songs.model.Song
import kotlinx.coroutines.launch

class AddSongViewModel(private val repository: Repository) : ViewModel() {

    fun createSong(song: Song) {
        viewModelScope.launch {
            try {
                repository.createSong(song)
            } catch (exception: Exception) {
                Log.e("AddSongViewModel", "Error creating song: ${exception.message}")
            }
        }
    }
}
