package com.udemy.my_songs.model

import com.udemy.my_songs.network.NetworkService

class Repository(private val networkService: NetworkService) {

    suspend fun retrieveSongs(): List<Song> {
        return networkService.retrieveSongs().songs ?: emptyList()
    }

    suspend fun createSong(song: Song) {
        networkService.createSong(song)
    }

    suspend fun removeSong(songId: String) {
        networkService.removeSong(songId)
    }
}