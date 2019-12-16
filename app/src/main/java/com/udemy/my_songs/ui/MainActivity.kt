package com.udemy.my_songs.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.udemy.my_songs.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        viewModel<SongsViewModel>() // To share with the rest of Fragments
    }
}
