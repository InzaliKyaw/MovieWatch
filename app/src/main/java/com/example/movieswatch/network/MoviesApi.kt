package com.example.movieswatch.network

import com.example.movieswatch.network.responses.*
import com.example.movieswatch.utils.*
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MoviesApi {
    @GET(GET_POPULAR_MOVIE)
    fun getPopularMovies(@Query("api_key")token:String):Observable<GetPopularMoviesResponse>

    @GET(GET_NOW_PLAYING_MOVIE)
    fun getNowPlayingMovie(@Query("api_key")token: String):Observable<GetNowPlayingMovieResponse>

    //Genre
    @GET(GET_LISTS)
    fun getLists(@Path("list_id")listid:Int,@Query("api_key")token: String):Observable<GetLists>

    @GET(GET_POPULAR_PERSON)
    fun getPopularPersons(@Query("api_key")token: String):Observable<GetPopularPersonResponse>

    @GET(GET_DETAIL_MOVIE)
    fun getDetailMovies(@Path("movie_id")movieid:Int,@Query("api_key")token: String):Observable<GetMovieDetailResponse>

    @GET(GET_MOVIE_DETAIL_ACTORS)
    fun getDetailMoviesActors(@Path("movie_id")movieid:Int,@Query("api_key")token: String):Observable<GetMovieDetailActor>

    @GET(GET_GENRES)
    fun getGenres(@Query("api_key")token: String):Observable<GetGenreResponse>

    @GET(GET_DISCOVER_MOVIE)
    fun getDiscoverMovies(@Query("with_geners")withGenres:Int,@Query("api_key")token: String):Observable<GetPopularMoviesResponse>
}