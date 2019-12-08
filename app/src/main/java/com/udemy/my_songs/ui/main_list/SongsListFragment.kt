package com.udemy.my_songs.ui.main_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.udemy.my_songs.R
import com.udemy.my_songs.model.Song
import kotlinx.android.synthetic.main.songs_list_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel


class SongsListFragment : Fragment() {

    private val viewModel: SongsListViewModel by viewModel()
    private val adapter by lazy { SongsRecyclerViewAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.songs_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureView()
        fetchSongs()
    }

    private fun configureView() {
        context?.let { context ->
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
            val swipeToDeleteCallback = SwipeToDeleteCallback(context, adapter, viewModel)
            val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
            itemTouchHelper.attachToRecyclerView(recyclerView)
        }

        addButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_to_addSongFragment)
        }

        swipeContainer.setOnRefreshListener {
            viewModel.refreshSongs()
        }
    }

    private fun fetchSongs() {
        swipeContainer.isRefreshing = true
        viewModel.getSongs().observe(
            viewLifecycleOwner, Observer { songsList -> displaySongs(songsList) }
        )
    }

    private fun displaySongs(songsList: List<Song>?) {
        adapter.songsList = songsList as MutableList<Song>
        swipeContainer.isRefreshing = false
    }

    companion object {
        operator fun invoke() = SongsListFragment()
    }
}