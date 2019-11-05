package com.udemy.my_songs.network

import com.udemy.my_songs.model.Song
import com.udemy.my_songs.network.dto.SongsResponseData
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface NetworkService {
    @GET("songs")
    suspend fun retrieveSongs(): SongsResponseData // Obtener el listado de canciones de todas las canciones.

    @POST("songs")
    fun createSong(song: Song) // Crear una nueva canción.

    @GET("songs/{id}")
    fun getSong(@Path("id") songId: String): Song // Obtener una canción dado su id.

    @PATCH("songs/{id}")
    fun updateSong(@Path("id") songId: String)  // Actualizar una canción dado su id.

    @DELETE("songs/{id}")
    fun removeSong(@Path("id") songId: String)  // Eliminar una canción dado su id.
}