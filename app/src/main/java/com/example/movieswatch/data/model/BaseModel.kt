package com.example.movieswatch.data.model

import android.content.Context
import com.example.movieswatch.data.vos.PopularityResultsVO
import com.example.movieswatch.network.MoviesApi
import com.example.movieswatch.network.responses.GetPopularMoviesResponse
import com.example.movieswatch.persistance.db.MovieDB
import com.example.movieswatch.utils.BASE_URL
import com.example.movieswatch.utils.NO_INTERNET_CONNECTION
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel{

    protected  var mMoviesApi:MoviesApi
    protected lateinit var mTheDB : MovieDB

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            //dependency htal ka Gson nae lr chate
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mMoviesApi = retrofit.create(MoviesApi::class.java)
    }
    fun initDatabase(context: Context){
        mTheDB = MovieDB.getDBInstance(context)
    }

//     fun getDiscoverMovie(
//         withGenres: Int,
//         accessToken: String,
//         onSuccess: (List<PopularityResultsVO>) -> Unit,
//         onFailure: (String) -> Unit
//    ) {
//        val getPopularMoviesCall = mMoviesApi?.getDiscoverMovies(withGenres,accessToken)
//         getPopularMoviesCall?.enqueue(object:Callback<GetPopularMoviesResponse>{
//             override fun onFailure(call: Call<GetPopularMoviesResponse>, t: Throwable) {
//                 onFailure(t.message ?: NO_INTERNET_CONNECTION)
//             }
//
//             override fun onResponse(
//                 call: Call<GetPopularMoviesResponse>,
//                 response: Response<GetPopularMoviesResponse>
//             ) {
//                 val getPopularMoviesResponse = response.body()
//                 if (getPopularMoviesResponse != null){
//                     getPopularMoviesResponse.results.let {
//                         if (it != null) {
//                             onSuccess(it)
//                         }
//                     }
//                 }else{
//                     onFailure(NO_INTERNET_CONNECTION)
//                     //failure
//                 }
//
//             }
//         })
//    }




}


    /*
    override fun getPopularMovies(accessToken: String,
                                  onSuccess:(List<PopularityResultsVO>)->Unit,
                                  onFailure:(String)->Unit) {

        //Call nae wrap htr loc
        val getPopularMovieCall = mMoviesApi?.getPopularMovies(accessToken)
        //Callback ka interface
        //Anonymous inner class= object
        getPopularMovieCall?.enqueue(object:Callback<GetPopularMoviesResponse>{

            override fun onFailure(call: Call<GetPopularMoviesResponse>, t: Throwable) {
                    onFailure(t.message ?: NO_INTERNET_CONNECTION)
            }

            override fun onResponse(
                call: Call<GetPopularMoviesResponse>,
                response: Response<GetPopularMoviesResponse>
            ) {

                    val getPopularMoviesResponse = response.body()
                    if(getPopularMoviesResponse != null){

                        getPopularMoviesResponse.results?.let {
                            onSuccess(it)
                        }!!
                        //success
                    }else{
                        onFailure(NO_INTERNET_CONNECTION)
                        //failure
                    }

            }

        })
    }





    override fun getNowPlayingMovies(
        accessToken: String,
        onSuccess: (List<PopularityResultsVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val getNowPlayingMovieResponseCall = mMoviesApi?.getNowPlayingMovie(accessToken)
        getNowPlayingMovieResponseCall?.enqueue(object:Callback<GetNowPlayingMovieResponse>{
            override fun onFailure(call: Call<GetNowPlayingMovieResponse>, t: Throwable) {
                onFailure(t.message ?: NO_INTERNET_CONNECTION)
            }

            override fun onResponse(
                call: Call<GetNowPlayingMovieResponse>,
                response: Response<GetNowPlayingMovieResponse>
            ) {
                val getNowPlayingMovieResponse = response.body()
                if(getNowPlayingMovieResponse != null){

                    getNowPlayingMovieResponse.results?.let {
                        onSuccess(it)
                    }!!
                    //success
                }else{
                    onFailure(NO_INTERNET_CONNECTION)
                    //failure
                }
            }

        }
        )
    }

    override fun getPopularPersons(
        accessToken: String,
        onSuccess: (List<PopularPersonResultsVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val getPopularPersonCall = mMoviesApi?.getPopularPersons(accessToken)
        getPopularPersonCall?.enqueue(object:Callback<GetPopularPersonResponse>{
            override fun onFailure(call: Call<GetPopularPersonResponse>, t: Throwable) {
                onFailure(t.message ?: NO_INTERNET_CONNECTION)
            }

            override fun onResponse(
                call: Call<GetPopularPersonResponse>,
                response: Response<GetPopularPersonResponse>
            ) {
                val getPopularPersonResponse = response.body()
                if (getPopularPersonResponse != null){
                    getPopularPersonResponse.results?.let {
                        onSuccess(it)
                    }!!
                }else{
                    onFailure(NO_INTERNET_CONNECTION)
                    //failure
                }
            }

        }
        )
    }

    override fun getLists(
        listID: Int,
        accessToken: String,
        onSuccess: (List<ItemsVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val getListsCall = mMoviesApi?.getLists(listID,accessToken)
        getListsCall?.enqueue(object:Callback<GetLists> {
            override fun onFailure(call: Call<GetLists>, t: Throwable) {
                onFailure(t.message ?: NO_INTERNET_CONNECTION)
            }

            override fun onResponse(call: Call<GetLists>, response: Response<GetLists>) {
                val getListsResponse = response.body()
                if (getListsResponse != null) {
                    getListsResponse.items?.let {
                        onSuccess(it)
                    }!!
                } else {
                    onFailure(NO_INTERNET_CONNECTION)
                }

            }

        })

    }
    override fun getMovieDetail(
        movieId: Int,
        accessToken: String,
        onSuccess: (GetMovieDetailResponse) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val getMovieDetailCall = mMoviesApi?.getDetailMovies(movieId,accessToken)
        getMovieDetailCall?.enqueue(object:Callback<GetMovieDetailResponse>{
            override fun onFailure(call: Call<GetMovieDetailResponse>, t: Throwable) {
                onFailure(t.message ?: NO_INTERNET_CONNECTION)

            }

            override fun onResponse(
                call: Call<GetMovieDetailResponse>,
                response: Response<GetMovieDetailResponse>
            ) {
                val getMovieDetailResponse = response.body()
                if (getMovieDetailResponse != null){
                    onSuccess(getMovieDetailResponse)
                }
            }

        } )
    }
    override fun getMovieDetailActors(
        movieId: Int,
        accessToken: String,
        onSuccess: (List<CastVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val getMovieDetailActorCall = mMoviesApi?.getDetailMoviesActors(movieId,accessToken)
        getMovieDetailActorCall?.enqueue(object:Callback<GetMovieDetailActor>{

            override fun onFailure(call: Call<GetMovieDetailActor>, t: Throwable) {
                onFailure(t.message ?: NO_INTERNET_CONNECTION)
            }

            override fun onResponse(
                call: Call<GetMovieDetailActor>,
                response: Response<GetMovieDetailActor>
            ) {
                val getMovieDetailActorResponse = response.body()
                if(getMovieDetailActorResponse!= null) {

                    getMovieDetailActorResponse.castVO?.let {
                        onSuccess(it)
                    }
                }else {
                    onFailure(NO_INTERNET_CONNECTION)
                }
            }

        })


    }

    override fun getMovieDetailCrew(
        movieId: Int,
        accessToken: String,
        onSuccess: (List<CrewVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val getMovieDetailActorCall = mMoviesApi?.getDetailMoviesActors(movieId, accessToken)
        getMovieDetailActorCall?.enqueue(object : Callback<GetMovieDetailActor> {
            override fun onFailure(call: Call<GetMovieDetailActor>, t: Throwable) {
                onFailure(t.message ?: NO_INTERNET_CONNECTION)
            }

            override fun onResponse(
                call: Call<GetMovieDetailActor>,
                response: Response<GetMovieDetailActor>
            ) {
                val getMovieDetailActorResponse = response.body()
                if (getMovieDetailActorResponse != null) {

                    getMovieDetailActorResponse.crewVO?.let {
                        onSuccess(it)
                    }
                } else {
                    onFailure(NO_INTERNET_CONNECTION)
                }
            }

        })
    }

    override fun getGenre(
        accessToken: String,
        onSuccess: (List<GenresVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val getGenresVOCall = mMoviesApi?.getGenres(accessToken)
        getGenresVOCall?.enqueue(object:Callback<GetGenreResponse>{
            override fun onFailure(call: Call<GetGenreResponse>, t: Throwable) {
                onFailure(t.message ?: NO_INTERNET_CONNECTION)
            }

            override fun onResponse(
                call: Call<GetGenreResponse>,
                response: Response<GetGenreResponse>
            ) {
                val getGenreResponse = response.body()
                if (getGenreResponse != null){
                    getGenreResponse?.genresVO?.let {
                        onSuccess(it)
                    }
                }else {
                    onFailure(NO_INTERNET_CONNECTION)
                }

            }

        })
    }

     */





