package com.example.movieswatch.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.movieswatch.data.model.MovieModelImpl
import com.example.movieswatch.data.model.MoviesModel
import com.example.movieswatch.mvp.view.MainView

class MainPresenterImpl :MainPresenter{

    private lateinit var lifecycleOwner: LifecycleOwner
    var mMovieModel:MoviesModel = MovieModelImpl


    override fun onTapGenreItems(genreId: Int) {
        requestMoviesByGenre(lifecycleOwner,genreId)
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

    override fun onTapMovie() {
        mView?.navigateToDetail()
    }

    override fun initPresenter(view: MainView) {
        mView = view
    }


    private fun requestMoviesByGenre(lifecycleOwner: LifecycleOwner,genreId: Int){
        mMovieModel.getDiscoverMovie(genreId)
            .observe(lifecycleOwner, Observer {
                val movieByGenre = it.filter{
                    movie ->
                    movie.genreIds.contains(genreId)
                }
                    .toList()
                mView?.displayMoviesByGenre(movieByGenre)
            })
    }


}


