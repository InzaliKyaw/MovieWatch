package com.example.movieswatch.mvp.view

import com.example.movieswatch.data.vos.GenresVO
import com.example.movieswatch.data.vos.PopularPersonResultsVO
import com.example.movieswatch.data.vos.PopularityResultsVO
import com.example.movieswatch.network.responses.GetMovieDetailResponse

interface MainView {
    // fun displayProfileList(task:ArrayList<Task>)
    fun navigateToDetail(movieId:Int)
    fun displayMoviesByGenre(movieList: List<PopularityResultsVO>)
    fun displayPopularMovieList(popularMovieList: List<PopularityResultsVO>)
    fun displayNowPlayingMovies(nowPlayingMovieList: List<PopularityResultsVO>)
    fun displayPopularPerson(popularPersonList: List<PopularPersonResultsVO>)
    fun setUpTabLayout()
    fun setGenresList(genresList: List<GenresVO>)


}