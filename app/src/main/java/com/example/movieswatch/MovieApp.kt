package com.example.movieswatch

import android.app.Application
import com.example.movieswatch.data.model.MovieModelImpl

class MovieApp:Application(){
    override fun onCreate() {
        super.onCreate()
        MovieModelImpl.initDatabase(applicationContext)
    }
}