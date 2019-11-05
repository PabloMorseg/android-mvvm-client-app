package com.udemy.my_songs.model

import com.udemy.my_songs.network.NetworkService

class Repository(private val networkService: NetworkService) :
    IRepository {

    override suspend fun getAllSongs(): List<Song> {
        return networkService.retrieveSongs().songs ?: emptyList()
    }
}