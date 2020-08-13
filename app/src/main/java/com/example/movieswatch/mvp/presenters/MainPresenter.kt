package com.example.movieswatch.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.movieswatch.delegates.MovieListDelegates
import com.example.movieswatch.mvp.view.MainView

interface MainPresenter:MovieListDelegates{

    fun onCreate()
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
    //Activity knows only interface class
    fun initPresenter(view: MainView)
    fun onTapGenreItems(lifecycleOwner: LifecycleOwner,genreId:Int)
    fun loadAllPopularMovieList(lifecycleOwner: LifecycleOwner)
    fun loadAllPopularActorList(lifecycleOwner: LifecycleOwner)
    fun loadNowPlayingMovie(lifecycleOwner: LifecycleOwner)
    fun loadGenre(lifecycleOwner: LifecycleOwner)
    fun onUiReady(lifecycleOwner: LifecycleOwner,genreId: Int)
}