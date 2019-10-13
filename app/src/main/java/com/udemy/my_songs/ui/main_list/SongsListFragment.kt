package com.udemy.my_songs.ui.main_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
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
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        viewModel = ViewModelProviders.of(this).get(SongsListViewModel::class.java)
        viewModel.allSongs.observe(
            this, Observer { songsList ->
                adapter.songsList = songsList
            }
        )

        addButton.setOnClickListener {
            // TODO
        }
    }

    companion object {
        operator fun invoke() = SongsListFragment()
    }
}