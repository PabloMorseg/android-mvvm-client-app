package com.udemy.my_songs.model

import com.google.gson.annotations.SerializedName

data class Song(val name: String, val artist: String, val year: Int) {
    @SerializedName("_id")
    var id: String? = null
}
