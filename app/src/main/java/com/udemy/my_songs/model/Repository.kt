package com.udemy.my_songs.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udemy.my_songs.network.NetworkService
import com.udemy.my_songs.utils.Mocker

class Repository(private val networkService: NetworkService) :
    IRepository {
    private var allSongs: MutableLiveData<List<Song>> = MutableLiveData()

    init {
        allSongs.value = fetchSongs()
    }

    override fun getAllSongs(): LiveData<List<Song>> {
        return allSongs
    }

    private fun fetchSongs(): List<Song> {
        return Mocker.createMockSongsList(50)
    }
}