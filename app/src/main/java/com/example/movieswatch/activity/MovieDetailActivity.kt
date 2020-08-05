package com.example.movieswatch.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movieswatch.R
import com.example.movieswatch.adapters.ActorMovieDetailAdapter
import com.example.movieswatch.adapters.CrewMovieDetailAdapter
import com.example.movieswatch.adapters.MoviePagerAdapter
import com.example.movieswatch.adapters.PopularActorAdapter
import com.example.movieswatch.data.model.MovieModelImpl
import com.example.movieswatch.data.model.MoviesModel
import com.example.movieswatch.network.responses.GetMovieDetailResponse
import com.example.movieswatch.persistance.db.MovieDB
import com.example.movieswatch.utils.IMAGE_BASE_URL
import com.example.movieswatch.view.viewpods.MovieDetailAboutFilmViewPod
import com.example.movieswatch.view.viewpods.MovieDetailPosterViewPod
import com.example.movieswatch.view.viewpods.MovieDetailStorylineViewPod
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.viewpod_movie_detail_about_films.*
import kotlinx.android.synthetic.main.viewpod_movie_detail_poster.*
import kotlinx.android.synthetic.main.viewpod_movie_story_line.*
import retrofit2.http.Tag

class MovieDetailActivity:AppCompatActivity() {

    private var mMovieModel: MoviesModel? = MovieModelImpl
    private lateinit var actorAdapter: ActorMovieDetailAdapter
    private lateinit var crewAdapter:CrewMovieDetailAdapter
    private lateinit var viewPodMovieDetailPosterViewPod: MovieDetailPosterViewPod
    private lateinit var viewPodMovieDetailStorylineViewPod: MovieDetailStorylineViewPod
    private lateinit var viewPodMovieDetailAboutFilmViewPod: MovieDetailAboutFilmViewPod
    private lateinit var data:GetMovieDetailResponse
    private lateinit var mTheDB: MovieDB

    var Tag = "MovieDetailActivity"

    companion object{

        fun newItent(context: Context): Intent {
            val intent =  Intent(context, MovieDetailActivity::class.java)
            //intent.putExtra("MovieID")
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        actorAdapter = ActorMovieDetailAdapter()
        crewAdapter = CrewMovieDetailAdapter()

        mMovieModel?.getMovieDetails(
            onSuccess = {
                mTheDB.movieDetailDao().insertAllMovieDetail(it)
                Log.d(Tag, "Movie Detail"+it)

                //setUpMovieDetailPosterViewPod(data)
               // slideContainer.adapter = MoviePagerAdapter(it)
            }, onError = {
                Log.e(Tag,"Error")
            }
        )

        mMovieModel?.getMovieDetailsActor(
            onSuccess = {
                //actorAdapter = ActorMovieDetailAdapter(it)
                mTheDB.castDao().insetCastList(it)
            }, onError = {
                Log.e(Tag,"Error")
            }
        )

        mMovieModel?.getMovieDetailsCrew(
            onSuccess = {
               // crewAdapter = CrewMovieDetailAdapter(it)
                mTheDB.crewDao().insertCrewList(it)
            }, onError = {
                Log.e(Tag,"Error")
            }
        )

        //InsertDB_To_View
        mTheDB = MovieDB.getDBInstance(this)
        mTheDB.castDao().getAllCast().observe(this,
            Observer {
                actorAdapter.setNewData(it.toMutableList())
            })
        setUpActorRecyclerView(actorAdapter)

        mTheDB.crewDao().getAllCrew().observe(this,
            Observer {

                crewAdapter.setNewData(it.toMutableList())
            })
        setUpCreatorRecyclerView(crewAdapter)

        mTheDB.movieDetailDao().getAllMovieDetail().observe(this,
            Observer {
                it?.let { movieDetail ->
                    setUpMovieDetailPosterViewPod(movieDetail)
                }

            })


    }

    fun setUpMovieDetailPosterViewPod(data:GetMovieDetailResponse){

        viewPodMovieDetailPosterViewPod = vpMovieDetailPoster as MovieDetailPosterViewPod
        viewPodMovieDetailStorylineViewPod = vpMovieStoryLine as MovieDetailStorylineViewPod
        viewPodMovieDetailAboutFilmViewPod = vpAboutFilm as MovieDetailAboutFilmViewPod

        Log.d(Tag,"Data detatil"+data.originalTitle)
        viewPodMovieDetailPosterViewPod.bindMoviePoster(data)
        viewPodMovieDetailStorylineViewPod.bindMovies(data)
        viewPodMovieDetailAboutFilmViewPod.bindAboutFilm(data)

    }

//    fun setUpMovieDetailPosterViewPod(data:GetMovieDetailResponse){
//        viewPodMovieDetailPosterViewPod = vpMovieDetailPoster as MovieDetailPosterViewPod
//        viewPodMovieDetailPosterViewPod.bindMoviePoster(data)
//    }

    fun setUpActorRecyclerView(actorAdapter: ActorMovieDetailAdapter) {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvActorDetail.layoutManager = linearLayoutManager
        rvActorDetail.adapter = actorAdapter
    }
    fun setUpCreatorRecyclerView(crewAdapter:CrewMovieDetailAdapter) {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCreatorDetail.layoutManager = linearLayoutManager
        rvCreatorDetail.adapter = crewAdapter
    }
}