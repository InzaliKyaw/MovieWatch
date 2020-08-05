package com.example.movieswatch.mvp.presenters

import com.example.movieswatch.delegates.MovieListDelegates
import com.example.movieswatch.mvp.view.MainView

interface MainPresenter:MovieListDelegates{

    fun onCreate()
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
    //override fun onTapMovie(id:Int)
    override fun onTapMovie()

    //Activity knows only interface class
    fun initPresenter(view: MainView)
    fun onTapGenreItems(genreId:Int)
}