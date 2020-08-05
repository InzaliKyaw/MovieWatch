package com.example.movieswatch.data.model

import androidx.lifecycle.LiveData
import com.example.movieswatch.data.vos.*
import com.example.movieswatch.network.responses.GetMovieDetailResponse
import com.example.movieswatch.persistance.db.MovieDB
import com.example.movieswatch.utils.MOVIE_ID
import com.example.movieswatch.utils.PARAM_ACCESS_TOKEN

object MovieModelImpl:MoviesModel,BaseModel() {
    private lateinit var mTheDB: MovieDB




    override fun getGenre(onSuccess: (List<GenresVO>) -> Unit, onError: (String) -> Unit) {
        mDataAgents.getGenre(PARAM_ACCESS_TOKEN,
            onSuccess = {
                onSuccess.invoke(it)
            },
            onFailure = {
                onError.invoke(it)
            })
    }

    override fun getMovieDetailsActor(onSuccess: (List<CastVO>) -> Unit, onError: (String) -> Unit) {
        mDataAgents.getMovieDetailActors(MOVIE_ID,PARAM_ACCESS_TOKEN,
            onSuccess= {
                onSuccess.invoke(it)
            },onFailure= {
                onError.invoke(it)
            })

    }

    override fun getMovieDetailsCrew(onSuccess: (List<CrewVO>) -> Unit, onError: (String) -> Unit) {
        mDataAgents.getMovieDetailCrew(MOVIE_ID,PARAM_ACCESS_TOKEN,
            onSuccess= {
                onSuccess.invoke(it)
            },onFailure= {
                onError.invoke(it)
            })

    }

    override fun getPopularPesons(
        onSuccess: (List<PopularPersonResultsVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        mDataAgents.getPopularPersons(PARAM_ACCESS_TOKEN,
        onSuccess={
            onSuccess.invoke(it)
        },
        onFailure = {
            onError.invoke(it)
        }    )
    }


    override fun getNowPlayingMovies(
        onSuccess: (List<PopularityResultsVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        mDataAgents.getPopularMovies(PARAM_ACCESS_TOKEN,
            onSuccess={
                onSuccess.invoke(it)
            },
            onFailure = {
                onError.invoke(it)
            })
    }

    override fun getPopularMovies(
        onSuccess: (List<PopularityResultsVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        mDataAgents.getPopularMovies(PARAM_ACCESS_TOKEN,
            onSuccess={
                onSuccess.invoke(it)
            },
            onFailure = {
                onError.invoke(it)
            })
    }

    override fun getLists(onSuccess: (List<ItemsVO>) -> Unit,
                          onError: (String) -> Unit) {
        mDataAgents.getLists(1,PARAM_ACCESS_TOKEN,
            onSuccess={
                onSuccess.invoke(it)
            },
            onFailure = {
                onError.invoke(it)
            })
    }

    override fun getMovieDetails(onSuccess: (GetMovieDetailResponse) -> Unit,
                          onError: (String) -> Unit) {
        mDataAgents.getMovieDetail( MOVIE_ID ,PARAM_ACCESS_TOKEN,
            onSuccess={
                onSuccess.invoke(it)
            },
            onFailure = {
                onError.invoke(it)
            })


    }

//    @SuppressLint("CheckResult")
//    override fun getDiscoverMovie(
//        genreId:Int):LiveData<List<PopularityResultsVO>> {
//        mDataAgents.getDiscoverMovie(GENRE_ID, PARAM_ACCESS_TOKEN)
//
//    }

//    override fun getMoviesByGenre(genre:Int): LiveData<List<PopularityResultsVO>> {
//        mDataAgents.getDiscoverMovies(genre,PARAM_ACCESS_TOKEN )
//            .map {
//                it.results?.toList()?: listOf() }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//
//                mTheDB.movieDao().insertAllMovies(it)
//            },{
//
//            })
//        return mTheDB.movieDao().getGenresMovies()
//    }

    override fun getDiscoverMovie(genreId: Int): LiveData<List<PopularityResultsVO>> {
        mDataAgents.getDiscoverMovie(genreId, PARAM_ACCESS_TOKEN)

        return mTheDB.allGenreDao().getGenresMovies()
    }



}


