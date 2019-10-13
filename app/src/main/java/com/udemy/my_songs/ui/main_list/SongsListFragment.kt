package com.udemy.my_songs.ui.main_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.udemy.my_songs.R
import com.udemy.my_songs.utils.Mocker
import kotlinx.android.synthetic.main.songs_list_fragment.*

class SongsListFragment : Fragment() {

    private lateinit var viewModel: SongsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.songs_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SongsListViewModel::class.java)
        // TODO: Use the ViewModel
        configureRecyclerView()
    }

    private fun configureRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = SongsRecyclerViewAdapter(
            Mocker.createMockSongsList(50)
        )
    }

    companion object {
        operator fun invoke() = SongsListFragment()
    }
}