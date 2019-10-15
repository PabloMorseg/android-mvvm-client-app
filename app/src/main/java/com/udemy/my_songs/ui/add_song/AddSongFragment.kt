package com.udemy.my_songs.ui.add_song

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.udemy.my_songs.R
import com.udemy.my_songs.model.Song
import kotlinx.android.synthetic.main.add_song_fragment.*

class AddSongFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.add_song_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        saveButton.setOnClickListener {
            saveNewSong()
        }
    }

    private fun saveNewSong() {
        val songName = songNameEditText.text.toString()
        val artistName = artistNameEditText.text.toString()
        val yearString = yearEditText.text.toString()
        if (songName.isNotEmpty() && artistName.isNotEmpty() && yearString.isNotEmpty()) {
            val song = Song(songName, artistName, yearString.toInt())
            // TODO: Enviar petición para guardar la canción
        } else {
            Toast.makeText(context, R.string.please_fill_all_the_fields, Toast.LENGTH_SHORT)
                .show()
        }
    }

    companion object {
        operator fun invoke() = AddSongFragment()
    }
}