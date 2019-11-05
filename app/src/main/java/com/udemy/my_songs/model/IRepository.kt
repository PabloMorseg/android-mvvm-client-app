package com.udemy.my_songs.model

interface IRepository {
    suspend fun getAllSongs(): List<Song>
}