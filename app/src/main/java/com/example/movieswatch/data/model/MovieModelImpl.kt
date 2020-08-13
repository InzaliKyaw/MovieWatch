package com.example.movieswatch.data.model

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.example.movieswatch.data.vos.*
import com.example.movieswatch.network.responses.GetMovieDetailResponse
import com.example.movieswatch.network.responses.GetPopularMoviesResponse
import com.example.movieswatch.utils.NO_INTERNET_CONNECTION
import com.example.movieswatch.utils.PARAM_ACCESS_TOKEN
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.viewpod_genre_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieModelImpl : MoviesModel, BaseModel() {

    private val Tag = "izk"
    private lateinit var mMoviesModel:MoviesModel

    @SuppressLint("CheckResult")
    override fun getNowPlayingMovies(onError: (String) -> Unit): LiveData<List<PopularityResultsVO>> {
        mMoviesApi.getNowPlayingMovie(PARAM_ACCESS_TOKEN).map {
            it.results?.toList() ?: listOf()
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.popularMovieResultsDao().insertPopularMovieList(it)
                Log.e(Tag, "Get Now Playing" + it)
            }, {
                onError(it.localizedMessage ?: NO_INTERNET_CONNECTION)
                Log.e(Tag, "Get Now Playing" + "ERROR")
            })

        return mTheDB.popularMovieResultsDao().getAllPopularMovie()
    }

    @SuppressLint("CheckResult")
    override fun getGenre(onError: (String) -> Unit): LiveData<List<GenresVO>> {
        mMoviesApi.getGenres(PARAM_ACCESS_TOKEN)
            .map {
                it.genresVO.toList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    mTheDB.genresDao().insertGenreList(it)
                    Log.d(Tag, "Get Genre" + it)

                }, {
                    onError(it.localizedMessage ?: NO_INTERNET_CONNECTION)
                    Log.d(Tag, "Get Genre" )

                }
            )
        return mTheDB.genresDao().getAllGenre()
    }





    @SuppressLint("CheckResult")
    override fun getDiscoverMovie(genreId: Int): LiveData<List<PopularityResultsVO>> {

        mMoviesApi.getDiscoverMovies(genreId, PARAM_ACCESS_TOKEN)
            .map{
                it.results?.toList()?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                mTheDB.allGenreDao().insertGenreList(it)
            },{
                Log.d(Tag, "Get Genre Movie" + it)

            })
        return mTheDB.allGenreDao().getAllMovies()
    }


    @SuppressLint("CheckResult")
    override fun getPopularMovies(onError: (String) -> Unit): LiveData<List<PopularityResultsVO>> {
        mMoviesApi.getPopularMovies(PARAM_ACCESS_TOKEN)
            .map {
                it.results?.toList() ?: listOf()
            }
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                {
                    mTheDB.popularMovieResultsDao().insertPopularMovieList(it)
                    Log.d(Tag, "Get Popular Movie" + it)

                }, {
                    onError(it.localizedMessage ?: NO_INTERNET_CONNECTION)
                    Log.d(Tag, "Get " + it)

                }
            )
        return mTheDB.popularMovieResultsDao().getAllPopularMovie()
    }

    @SuppressLint("CheckResult")
    override fun getPopularPesons(onError: (String) -> Unit): LiveData<List<PopularPersonResultsVO>> {
        mMoviesApi.getPopularPersons(PARAM_ACCESS_TOKEN)
            .map {
                it.results?.toList() ?: listOf()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.popularPersonDao().insertPopularPersonList(it)
            }, {
                onError(it.localizedMessage ?: NO_INTERNET_CONNECTION)
            })

        return mTheDB.popularPersonDao().getAllPopularPerson()
    }




    @SuppressLint("CheckResult")
    override fun getMovieDetails(
        movieId: Int,
        onError: (String) -> Unit
    ): LiveData<GetMovieDetailResponse?> {
        mMoviesApi.getDetailMovies(movieId, PARAM_ACCESS_TOKEN)
            .map {
                it
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.movieDetailDao().insertAllMovieDetail(it)
            },{
                onError(it.localizedMessage ?: NO_INTERNET_CONNECTION)
            })
        return mTheDB.movieDetailDao().getMovieWithIdentity()

    }

    @SuppressLint("CheckResult")
    override fun getMovieDetailsActor(
        movieId: Int,
        onError: (String) -> Unit
    ): LiveData<List<CastVO>> {
        mMoviesApi.getDetailMoviesActors(movieId, PARAM_ACCESS_TOKEN)
            .map {
                it.castVO?.toList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.castDao().insetCastList(it)
            },{
                onError(it.localizedMessage ?: NO_INTERNET_CONNECTION)
            })
        return mTheDB.castDao().getAllCast()


    }

    @SuppressLint("CheckResult")
    override fun getMovieDetailsCrew(
        movieId: Int,
        onError: (String) -> Unit
    ): LiveData<List<CrewVO>> {
        mMoviesApi.getDetailMoviesActors(movieId, PARAM_ACCESS_TOKEN)
            .map {
                it.crewVO.toList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                mTheDB.crewDao().insertCrewList(it)
            },{
            onError(it.localizedMessage ?: NO_INTERNET_CONNECTION)
        })
        return mTheDB.crewDao().getAllCrew()
    }



}