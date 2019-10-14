package com.udemy.my_songs.ui.add_song

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udemy.my_songs.R

class AddSongFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.add_song_fragment, container, false)
    }

    companion object {
        operator fun invoke() = AddSongFragment()
    }
}