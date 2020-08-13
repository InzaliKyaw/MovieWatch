package com.example.movieswatch.mvp.presenters

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.movieswatch.data.model.MovieModelImpl
import com.example.movieswatch.data.model.MoviesModel
import com.example.movieswatch.data.vos.PopularityResultsVO
import com.example.movieswatch.mvp.view.MainView
import retrofit2.http.Tag
import kotlin.math.log

class MainPresenterImpl :MainPresenter{

    var mMovieModel:MoviesModel = MovieModelImpl
    var Tag = "izk"
    private lateinit var lifecycleOwner: LifecycleOwner




    override fun onTapGenreItems(lifecycleOwner: LifecycleOwner,genreId: Int) {
        this.lifecycleOwner = lifecycleOwner
        requestMoviesByGenre(lifecycleOwner, genreId)
    }

    override fun loadNowPlayingMovie(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getNowPlayingMovies(onError = {
            Log.d(Tag,"loadNowPlayingMovie"+ it)
        }).observe(lifecycleOwner, Observer {
            mView?.displayNowPlayingMovies(it)
        })
    }

    override fun loadGenre(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getGenre(onError = {
            Log.d(Tag,"loadNowPlayingMovie"+ it)}).observe(
            lifecycleOwner, Observer {
                mView?.setGenresList(it)
            }
        )
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner, genreId: Int) {
        requestMoviesByGenre(lifecycleOwner,genreId)

    }

    override fun loadAllPopularMovieList(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getPopularMovies(
            onError = {
                Log.d(Tag,"loadAllPopularMovieList"+ it)
            }
        ).observe(lifecycleOwner, Observer {
            mView?.displayPopularMovieList(it)
        })
    }

    override fun loadAllPopularActorList(lifecycleOwner: LifecycleOwner) {
        mMovieModel.getPopularPesons(onError ={
            Log.d(Tag,"loadAllPopularActorList"+it)
        }).observe(lifecycleOwner, Observer {
            mView?.displayPopularPerson(it)
        })
    }





    private var mView:MainView ?= null

    override fun onCreate() {

    }

    override fun onStart() {

    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onStop() {

    }

    override fun onDestroy() {

    }

    override fun onTapMovie(movieId:Int) {
        mView?.navigateToDetail(movieId)
    }

    override fun initPresenter(view: MainView) {
        mView = view
    }

    private fun requestMoviesByGenre(lifecycleOwner: LifecycleOwner, genreId: Int) {
        mMovieModel?.getDiscoverMovie(genreId)
            .observe(lifecycleOwner, Observer {
                val moviesByGenre = it.filter { movie ->
                    movie.genreIds.contains(genreId)
                }
                    .toList()
                mView?.displayMoviesByGenre(moviesByGenre)
            })

    }



}


