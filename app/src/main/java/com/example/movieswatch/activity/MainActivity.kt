package com.example.movieswatch.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.movieswatch.R
import com.example.movieswatch.adapters.*
import com.example.movieswatch.data.model.MovieModelImpl
import com.example.movieswatch.data.model.MoviesModel
import com.example.movieswatch.data.vos.GenresVO
import com.example.movieswatch.data.vos.PopularityResultsVO
import com.example.movieswatch.mvp.presenters.MainPresenter
import com.example.movieswatch.mvp.presenters.MainPresenterImpl
import com.example.movieswatch.mvp.view.MainView
import com.example.movieswatch.persistance.db.MovieDB
import com.example.movieswatch.view.viewpods.ActorViewPod
import com.example.movieswatch.view.viewpods.PopularMovieViewPod
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.viewpod_genre_movies.*
import kotlinx.android.synthetic.main.viewpod_slide_movie.*

class MainActivity : AppCompatActivity(),MainView {



    private var mMovieModel: MoviesModel? = MovieModelImpl
    private lateinit var popularAdapter: PopularMovieAdapter
    private lateinit var actorAdapter: PopularActorAdapter
    private lateinit var viewPodPopular: PopularMovieViewPod
    private lateinit var viewPodActor: ActorViewPod
    private lateinit var genreMovieAdapter:GenreMovieAdapter
    private lateinit var mTheDB:MovieDB
   // private lateinit var viewPodGenreMoviesViewPod: GenreMoviesViewPod
    private lateinit var mPresenter:MainPresenter


    private lateinit var genresVOList: List<GenresVO>
    private lateinit var discoverList: List<PopularityResultsVO>
    private var itemList: ArrayList<Int> = arrayListOf()

//    private lateinit var popularMovieList: List<PopularityResultsVO>
//    private lateinit var allMoviesList: List<ItemsVO>
//    private lateinit var popularActorList:List<PopularPersonResultsVO>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        popularAdapter = PopularMovieAdapter(mPresenter)
        actorAdapter = PopularActorAdapter()
        genreMovieAdapter= GenreMovieAdapter()

        mMovieModel?.getPopularMovies(
            onSuccess = {
                mTheDB.popularMovieResultsDao().insertPopularMovieList(it)
            }, onError = {

            }
        )

        mMovieModel?.getNowPlayingMovies(
            onSuccess = {
                slideContainer.adapter = MoviePagerAdapter(it)
            }, onError = {

            }
        )

        mMovieModel?.getGenre(
            onSuccess = {
                genresVOList = it
                it.forEach {
                    //tabs.addTab(tabs.newTab().setText(it.name))
                }
            },onError = {

            }
        )

//        mMovieModel?.getLists(
//            onSuccess = {
//                mTheDB.itemDao().insertItemList(it)
//                it.forEach {
//                    var size = it.genreIds.size
//                   for (i in 0..size){
//                       //itemList.add(i)
//
//                   }
//                }
//
//            },onError = {
//
//            }
//        )

            tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabReselected(tab: TabLayout.Tab?) {


            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

                    var gerne= genresVOList.get(tab?.position ?: 0)
                    mPresenter.onTapGenreItems(gerne.id)

            }

        })






        mMovieModel?.getPopularPesons(
            onSuccess = {
                mTheDB.popularPersonDao().insertPopularPersonList(it)
            }, onError = {

            }
        )

        //PopularMovie_InsertDatafromDB_TO_View
        mTheDB = MovieDB.getDBInstance(this)
        mTheDB.popularMovieResultsDao().getAllPopularMovie().observe(this,
            Observer {
                popularAdapter.setNewData(it.toMutableList())
            })
        setUpPopularViewPod(popularAdapter)




        //PopularActor_InsertDatafromDB_TO_View
          mTheDB.popularPersonDao().getAllPopularPerson().observe(this,
            Observer {
                actorAdapter.setNewData(it.toMutableList())

            })
        setUpActorViewPod(actorAdapter)

    }


    fun setUpPopularViewPod(popularAdapter: PopularMovieAdapter){
        viewPodPopular = vpPopular as PopularMovieViewPod
        viewPodPopular.setMovieData(popularAdapter)
    }

    fun setUpActorViewPod(actorAdapter: PopularActorAdapter){
        viewPodActor = vpActor as ActorViewPod
        viewPodActor.setActorMovieData(actorAdapter)
    }


    override fun navigateToDetail( ){
        startActivity(MovieDetailActivity.newItent(this))
    }
    fun setUpPresenter(){
        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(this)
    }
    override fun displayMoviesByGenre(movieList: List<PopularityResultsVO>) {
        genreMovieAdapter.setNewData(movieList.toMutableList())
    }
}
