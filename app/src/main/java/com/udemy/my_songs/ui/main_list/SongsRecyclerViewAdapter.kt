package com.udemy.my_songs.ui.main_list

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udemy.my_songs.inflate
import com.udemy.my_songs.model.Song


class SongsRecyclerViewAdapter : RecyclerView.Adapter<SongsRecyclerViewAdapter.ViewHolder>() {

    var songsList: MutableList<Song> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflatedView = parent.inflate(com.udemy.my_songs.R.layout.recyclerview_item_row, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount() = songsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = songsList[position]
        holder.bind(song)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nameTextView: TextView = itemView.findViewById(com.udemy.my_songs.R.id.name)
        private var artistTextView: TextView = itemView.findViewById(com.udemy.my_songs.R.id.artist)
        private var yearTextView: TextView = itemView.findViewById(com.udemy.my_songs.R.id.year)

        fun bind(song: Song) {
            nameTextView.text = song.name
            artistTextView.text = song.artist
            yearTextView.text = song.year.toString()
        }
    }

    fun deleteItem(position: Int) {
        songsList.removeAt(position)
        notifyItemRemoved(position)
    }
}