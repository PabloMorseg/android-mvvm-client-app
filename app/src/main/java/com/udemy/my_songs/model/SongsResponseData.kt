package com.udemy.my_songs.model

import com.google.gson.annotations.SerializedName

class SongsResponseData {
    @SerializedName("data")
    var songs: List<Song>? = null
}