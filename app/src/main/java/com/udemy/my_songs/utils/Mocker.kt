package com.udemy.my_songs.utils

import com.udemy.my_songs.model.Song
import kotlin.random.Random

class Mocker {
    companion object {
        fun createMockSongsList(total: Int): List<Song> {
            val songs = mutableListOf<Song>()
            for (i in 1..total) {
                songs.add(
                    Song(
                        "Nombre de la canción $i",
                        "Nombre del artista $i",
                        Random.nextInt(1950, 2019)
                    )
                )
            }
            return songs
        }
    }
}