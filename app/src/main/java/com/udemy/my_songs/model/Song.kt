package com.udemy.my_songs.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Song(var name: String, var artist: String, var year: Int) : Parcelable {
    @SerializedName("_id")
    var id: String? = null
}
