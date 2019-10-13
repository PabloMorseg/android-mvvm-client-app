package com.udemy.my_songs.ui.main_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udemy.my_songs.model.Song
import com.udemy.my_songs.utils.Mocker

class SongsListViewModel : ViewModel() {
    val songsList: MutableLiveData<List<Song>>
        get() = _songsList
    private val _songsList: MutableLiveData<List<Song>> = MutableLiveData()

    fun fetchSongs() {
        _songsList.postValue(Mocker.createMockSongsList(50))
    }
}
