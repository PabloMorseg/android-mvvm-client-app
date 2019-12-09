package com.udemy.my_songs.model

import com.google.gson.annotations.SerializedName

data class Song(var name: String, var artist: String, var year: Int) {
    @SerializedName("_id")
    var id: String? = null
}
