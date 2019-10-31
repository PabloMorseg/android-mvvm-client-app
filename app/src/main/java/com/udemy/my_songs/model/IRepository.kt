package com.udemy.my_songs.model

import androidx.lifecycle.LiveData

interface IRepository {
    fun getAllSongs(): LiveData<List<Song>>
}