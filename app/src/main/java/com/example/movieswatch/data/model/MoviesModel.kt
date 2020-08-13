package com.example.movieswatch.data.model

import androidx.lifecycle.LiveData
import com.example.movieswatch.data.vos.*
import com.example.movieswatch.network.responses.GetMovieDetailResponse

interface MoviesModel{
    fun getPopularMovies(onError:(String) -> Unit):LiveData<List<PopularityResultsVO>>

    fun getNowPlayingMovies(onError:(String) -> Unit):LiveData<List<PopularityResultsVO>>

    fun getPopularPesons(onError:(String) -> Unit):LiveData<List<PopularPersonResultsVO>>

    fun getMovieDetails(movieId:Int, onError:(String) -> Unit):LiveData<GetMovieDetailResponse?>

    fun getMovieDetailsActor(movieId:Int,onError: (String) -> Unit):LiveData<List<CastVO>>

    fun getMovieDetailsCrew(movieId:Int,onError: (String) -> Unit):LiveData<List<CrewVO>>

    fun getGenre(onError: (String) -> Unit):LiveData<List<GenresVO>>

//    fun getDiscoverMovie(genreId:Int,onSuccess:(List<PopularityResultsVO>))

    fun getDiscoverMovie(genreId:Int):LiveData<List<PopularityResultsVO>>

}