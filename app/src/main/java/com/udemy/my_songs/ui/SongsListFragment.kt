package com.udemy.my_songs.ui

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
import com.udemy.my_songs.ui.adapter.SongsRecyclerViewAdapter
import com.udemy.my_songs.ui.adapter.SwipeToDeleteCallback
import kotlinx.android.synthetic.main.songs_list_fragment.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class SongsListFragment : Fragment(), SongsRecyclerViewAdapter.OnItemClickListener {

    private val viewModel by sharedViewModel<SongsViewModel>()
    private val adapter by lazy { SongsRecyclerViewAdapter(this) }

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

    override fun onResume() {
        super.onResume()
        viewModel.refreshSongs(false)
    }

    private fun configureView() {
        context?.let { context ->
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
            val swipeToDeleteCallback =
                SwipeToDeleteCallback(
                    context,
                    adapter,
                    viewModel
                )
            val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
            itemTouchHelper.attachToRecyclerView(recyclerView)
        }

        addButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_to_addSongFragment)
        }

        swipeContainer.setOnRefreshListener {
            viewModel.refreshSongs(true)
        }
    }

    override fun onItemClick(song: Song) {
        val bundle = Bundle()
        bundle.putParcelable(SONG_KEY, song)
        view?.findNavController()?.navigate(R.id.action_to_editSongFragment, bundle)
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
        const val SONG_KEY = "song_key"
    }
}