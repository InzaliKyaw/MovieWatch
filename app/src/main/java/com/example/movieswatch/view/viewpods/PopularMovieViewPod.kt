package com.example.movieswatch.view.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieswatch.adapters.PopularMovieAdapter
import kotlinx.android.synthetic.main.viewpod_popular_movie.*
import kotlinx.android.synthetic.main.viewpod_popular_movie.view.*

class PopularMovieViewPod@JvmOverloads constructor(
    context: Context, attrs: AttributeSet?= null, defStyleAttr:Int = 0
): LinearLayout(context, attrs, defStyleAttr) {
    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setMovieData(popularMovieAdapter:PopularMovieAdapter){
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvPopularMovies.layoutManager = linearLayoutManager
        rvPopularMovies.adapter = popularMovieAdapter
    }

}