package com.udemy.my_songs.ui.main_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.udemy.my_songs.R
import kotlinx.android.synthetic.main.songs_list_fragment.*


class SongsListFragment : Fragment() {

    private lateinit var viewModel: SongsListViewModel
    private var adapter = SongsRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.songs_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureView()
    }

    private fun configureView() {
        context?.let { context ->
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
            val swipeToDeleteCallback = SwipeToDeleteCallback(context, adapter)
            val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
            itemTouchHelper.attachToRecyclerView(recyclerView)
        }

        viewModel = ViewModelProviders.of(this).get(SongsListViewModel::class.java)
        viewModel.allSongs.observe(
            this, Observer { songsList ->
                adapter.songsList = songsList.toMutableList()
            }
        )

        addButton.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_to_addSongFragment)
        }
    }

    companion object {
        operator fun invoke() = SongsListFragment()
    }
}