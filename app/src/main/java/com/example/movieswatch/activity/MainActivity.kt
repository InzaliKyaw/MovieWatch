package com.example.movieswatch.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.movieswatch.R
import com.example.movieswatch.adapters.GenreMovieAdapter
import com.example.movieswatch.adapters.MoviePagerAdapter
import com.example.movieswatch.adapters.PopularActorAdapter
import com.example.movieswatch.adapters.PopularMovieAdapter
import com.example.movieswatch.data.model.MovieModelImpl
import com.example.movieswatch.data.model.MoviesModel
import com.example.movieswatch.data.vos.GenresVO
import com.example.movieswatch.data.vos.PopularPersonResultsVO
import com.example.movieswatch.data.vos.PopularityResultsVO
import com.example.movieswatch.mvp.presenters.MainPresenter
import com.example.movieswatch.mvp.presenters.MainPresenterImpl
import com.example.movieswatch.mvp.view.MainView
import com.example.movieswatch.network.responses.GetMovieDetailResponse
import com.example.movieswatch.persistance.db.MovieDB
import com.example.movieswatch.utils.PARAM_ACCESS_TOKEN
import com.example.movieswatch.view.viewpods.ActorViewPod
import com.example.movieswatch.view.viewpods.GenreMoviesViewPod
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
    private lateinit var viewPodGenre: GenreMoviesViewPod
    private lateinit var genreMovieAdapter:GenreMovieAdapter
    private lateinit var mTheDB:MovieDB
    private var genre = 12
    // private lateinit var viewPodGenreMoviesViewPod: GenreMoviesViewPod
    private lateinit var mPresenter:MainPresenter


    private  var genresVOList: List<GenresVO> = arrayListOf()
    private var genresName = arrayListOf<String>()
    private var genresId = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        popularAdapter = PopularMovieAdapter(mPresenter)
        actorAdapter = PopularActorAdapter()
        genreMovieAdapter= GenreMovieAdapter()

        mTheDB = MovieDB.getDBInstance(this)

            tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabReselected(tab: TabLayout.Tab?) {


            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
//                if (genresVOList!=null){
//                    var gerne= genresVOList.get(tab?.position ?: 0)
//                    mPresenter.onTapGenreItems(this@MainActivity,gerne.id)
//                }
                if(genresId != null){
                    genre = genresId[tabs.selectedTabPosition]
                    mPresenter.onTapGenreItems(this@MainActivity,genre)
                }

            }

        })

        mPresenter.onUiReady(this,genre)
        mPresenter.loadNowPlayingMovie(this)
        mPresenter.loadAllPopularMovieList(this)
        mPresenter.loadAllPopularActorList(this)
        mPresenter.loadGenre(this)



        //PopularMovie_InsertDatafromDB_TO_View
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

    override fun setUpTabLayout(){

        mTheDB.genresDao().getAllGenre().observe(
            this,
            Observer {
                genresVOList = it
                for (i in it ){
                    tabs.addTab(tabs.newTab().setText(i.name))
                }
            }
        )



//        mTheDB.allGenreDao().getGenresMovies(genre).observe(
//            this,
//            Observer {
//                genreMovieAdapter.setNewData(it.toMutableList())
//            }
//        )
        setUpGenreViewPod(genreMovieAdapter)

    }

    override fun setGenresList(genresList: List<GenresVO>) {
        for(i in 0 until genresList.count()) {
            genresName.add(genresList[i].name)
            genresId.add(genresList[i].id)
        }
        setUpTabLayout()
    }


    fun setUpPopularViewPod(popularAdapter: PopularMovieAdapter){
        viewPodPopular = vpPopular as PopularMovieViewPod
        viewPodPopular.setMovieData(popularAdapter)
    }

    fun setUpActorViewPod(actorAdapter: PopularActorAdapter){
        viewPodActor = vpActor as ActorViewPod
        viewPodActor.setActorMovieData(actorAdapter)
    }

    fun setUpGenreViewPod(genreMovieAdapter: GenreMovieAdapter){
        viewPodGenre = vpGenresMovie as GenreMoviesViewPod
        viewPodGenre.setGenreMovieData(genreMovieAdapter)
    }


    override fun navigateToDetail(movieId:Int){
        startActivity(MovieDetailActivity.newItent(this,movieId))
        finish()
    }
    fun setUpPresenter(){
        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(this)
    }



    override fun displayMoviesByGenre(movieList: List<PopularityResultsVO>) {
        genreMovieAdapter.setNewData(movieList.toMutableList())
    }

    override fun displayPopularMovieList(popularMovieList: List<PopularityResultsVO>) {
        popularAdapter.setNewData(popularMovieList.toMutableList())
    }

    override fun displayNowPlayingMovies(nowPlayingMovieList: List<PopularityResultsVO>) {
        slideContainer.adapter = MoviePagerAdapter(nowPlayingMovieList)
                dots_indicator.setViewPager2(slideContainer)
    }

    override fun displayPopularPerson(popularPersonList: List<PopularPersonResultsVO>) {
        actorAdapter.setNewData(popularPersonList.toMutableList())
    }


}
