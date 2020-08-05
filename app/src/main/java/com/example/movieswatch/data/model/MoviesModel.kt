package com.example.movieswatch.data.model

import androidx.lifecycle.LiveData
import com.example.movieswatch.data.vos.*
import com.example.movieswatch.network.responses.GetMovieDetailResponse

interface MoviesModel{
    fun getPopularMovies(onSuccess:(List<PopularityResultsVO>)-> Unit,
                         onError:(String) -> Unit)

    fun getNowPlayingMovies(onSuccess:(List<PopularityResultsVO>)-> Unit,
                            onError:(String) -> Unit)

    fun getLists(onSuccess:(List<ItemsVO>)-> Unit,
                 onError:(String) -> Unit)

    fun getPopularPesons(
        onSuccess:(List<PopularPersonResultsVO>)-> Unit,
        onError:(String) -> Unit
    )

    fun getMovieDetails(
        onSuccess:(GetMovieDetailResponse)-> Unit,
        onError:(String) -> Unit
    )

    fun getMovieDetailsActor(
        onSuccess:(List<CastVO>) -> Unit,
        onError: (String) -> Unit
    )

    fun getMovieDetailsCrew(
        onSuccess:(List<CrewVO>) -> Unit,
        onError: (String) -> Unit
    )

    fun getGenre(
        onSuccess:(List<GenresVO>) -> Unit,
        onError: (String) -> Unit
    )

    fun getDiscoverMovie(
        genreId:Int
    ):LiveData<List<PopularityResultsVO>>

}