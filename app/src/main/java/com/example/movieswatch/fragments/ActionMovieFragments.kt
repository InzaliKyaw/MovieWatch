package com.example.movieswatch.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieswatch.R
import com.example.movieswatch.adapters.GenreMovieAdapter
import com.example.movieswatch.data.model.MovieModelImpl
import com.example.movieswatch.data.model.MoviesModel
import com.example.movieswatch.view.viewpods.GenreMoviesViewPod
import kotlinx.android.synthetic.main.fragment_tab.*

//
//class ActionMovieFragments:Fragment(){
//
//    val ARG_COUNT:String = "param1"
//    private var mMovieModel: MoviesModel? = MovieModelImpl
//    private lateinit var genreMovieAdapter:GenreMovieAdapter
//    private lateinit var viewPodGenreMoviesViewPod: GenreMoviesViewPod
//
//
//    fun newInstance(counter: Int?): ActionMovieFragments {
//        val fragment = ActionMovieFragments()
//        val args = Bundle()
//        args.putInt(ARG_COUNT, counter!!)
//        fragment.setArguments(args)
//        return fragment
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        mMovieModel?.getLists(
//            onSuccess = {
//                genreMovieAdapter= GenreMovieAdapter(it)
//                setGenreMovieData(genreMovieAdapter)
//            },onError = {
//
//            }
//        )
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_tab,container,false)
//        return view
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }
//
////    fun setUpGenerMovieViewPod(genreMovieAdapter: GenreMovieAdapter){
////        viewPodGenreMoviesViewPod = vpGenresMovie as GenreMoviesViewPod
////        viewPodGenreMoviesViewPod.setGenreMovieData(genreMovieAdapter)
////    }
//
//    fun setGenreMovieData(genreMovieAdapter: GenreMovieAdapter){
//        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        rvGenre.layoutManager = linearLayoutManager
//        rvGenre.adapter = genreMovieAdapter
//    }


//}