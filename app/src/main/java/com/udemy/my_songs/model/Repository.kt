package com.udemy.my_songs.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udemy.my_songs.utils.Mocker

class Repository {
    private var allSongs: MutableLiveData<List<Song>> = MutableLiveData()

    init {
        allSongs.value = fetchSongs()
    }

    fun getAllSongs(): LiveData<List<Song>> {
        return allSongs
    }

    private fun fetchSongs(): List<Song> {
        return Mocker.createMockSongsList(50)
    }
}