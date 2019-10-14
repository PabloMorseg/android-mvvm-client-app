package com.udemy.my_songs.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.udemy.my_songs.R
import com.udemy.my_songs.ui.main_list.SongsListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SongsListFragment())
                .commitNow()
        }
    }
}
