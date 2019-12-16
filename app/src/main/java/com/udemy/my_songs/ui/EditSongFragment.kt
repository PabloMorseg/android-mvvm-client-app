package com.udemy.my_songs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.udemy.my_songs.R
import com.udemy.my_songs.hideKeyboard
import com.udemy.my_songs.model.Song
import com.udemy.my_songs.ui.SongsListFragment.Companion.SONG_KEY
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.detail_song_fragment.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class EditSongFragment : Fragment() {

    private val viewModel by sharedViewModel<SongsViewModel>()

    private var song: Song? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.detail_song_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        saveButton.setOnClickListener {
            updateSong()
            activity?.hideKeyboard()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.toolbar?.title = resources.getString(R.string.edit_song)
        song = arguments?.getParcelable(SONG_KEY) as Song?
        setupView(song)
    }

    private fun setupView(song: Song?) {
        song?.apply {
            songNameEditText.setText(name)
            artistNameEditText.setText(artist)
            yearEditText.setText(year.toString())
        }
    }

    private fun updateSong() {
        val songName = songNameEditText.text.toString()
        val artistName = artistNameEditText.text.toString()
        val yearString = yearEditText.text.toString()
        if (songName.isNotEmpty() && artistName.isNotEmpty() && yearString.isNotEmpty()) {
            song?.apply {
                name = songName
                artist = artistName
                year = yearString.toInt()
                viewModel.updateSong(this)
                Toast.makeText(context, R.string.song_saved_successfully, Toast.LENGTH_LONG)
                    .show()
            }
        } else {
            Toast.makeText(context, R.string.please_fill_all_the_fields, Toast.LENGTH_SHORT)
                .show()
        }
    }
}