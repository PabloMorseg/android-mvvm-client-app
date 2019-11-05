package com.udemy.my_songs.network.dto

import com.google.gson.annotations.SerializedName
import com.udemy.my_songs.model.Song

class SongsResponseData {
    @SerializedName("data")
    var songs: List<Song>? = null
}