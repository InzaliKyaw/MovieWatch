package com.example.movieswatch.mvp.presenters

import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.movieswatch.data.model.MovieModelImpl
import com.example.movieswatch.data.model.MoviesModel
import com.example.movieswatch.mvp.view.DetailView
import com.example.movieswatch.utils.PARAM_ACCESS_TOKEN

class DetailPresenterImpl:DetailPresenter {
    private var mView: DetailView?= null
    private var mMoviesModel:MoviesModel = MovieModelImpl
    private  var Tag = "IZK"

    override fun onUiReady(lifecycleOwner: LifecycleOwner, movieId: Int) {
        movieId.let {
            loadMovieDetail(lifecycleOwner, it)
        }
        loadActorDetail(lifecycleOwner, movieId)
        loadCrewDetail(lifecycleOwner, movieId)
    }
    fun loadMovieDetail(lifecycleOwner: LifecycleOwner,movieId: Int){
        mMoviesModel.getMovieDetails(movieId, onError = {
                Log.d(Tag,"Movie Detail Error"+it)
        }).observe(lifecycleOwner, Observer {

            mView?.displayDetail(it)
        })

    }
    fun loadActorDetail(lifecycleOwner: LifecycleOwner,movieId: Int){
        mMoviesModel.getMovieDetailsActor(movieId,onError = {

        }).observe(lifecycleOwner, Observer {
            mView?.displayActorList(it)
        })
    }
    fun loadCrewDetail(lifecycleOwner: LifecycleOwner,movieId: Int){
        mMoviesModel.getMovieDetailsCrew(movieId,onError = {

        }).observe(lifecycleOwner, Observer {
            mView?.displayCrewList(it)
        })
    }
    override fun initPresenter(view: DetailView) {
        mView = view
    }



}