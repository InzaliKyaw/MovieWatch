package com.example.movieswatch.network.dataagent

import com.example.movieswatch.data.vos.*
import com.example.movieswatch.network.responses.GetMovieDetailResponse

interface MoviesDataAgents {

    fun getPopularMovies(accessToken:String,
                         onSuccess:(List<PopularityResultsVO>) -> Unit,
                         onFailure:(String) -> Unit)

    fun getNowPlayingMovies(accessToken:String,
                            onSuccess:(List<PopularityResultsVO>) -> Unit,
                            onFailure:(String) -> Unit)

    fun getLists(listID:Int,
                 accessToken:String,
                 onSuccess:(List<ItemsVO>) -> Unit,
                 onFailure:(String) -> Unit)

    fun getPopularPersons(
        accessToken:String,
        onSuccess:(List<PopularPersonResultsVO>) -> Unit,
        onFailure:(String) -> Unit
    )

    fun getMovieDetail(movieId:Int,
                 accessToken:String,
                 onSuccess:(GetMovieDetailResponse) -> Unit,
                 onFailure:(String) -> Unit)

    fun getMovieDetailActors(
        movieId:Int,
        accessToken:String,
        onSuccess:(List<CastVO>) -> Unit,
        onFailure:(String) -> Unit
    )

    fun getMovieDetailCrew(
        movieId:Int,
        accessToken:String,
        onSuccess:(List<CrewVO>) -> Unit,
        onFailure:(String) -> Unit
    )

    fun getGenre(
        accessToken:String,
        onSuccess:(List<GenresVO>) -> Unit,
        onFailure:(String) -> Unit
    )

    fun getDiscoverMovie(
        withGenres:Int,
        accessToken:String
    )


}