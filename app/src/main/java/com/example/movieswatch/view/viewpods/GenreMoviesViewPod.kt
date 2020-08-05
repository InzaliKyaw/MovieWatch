package com.example.movieswatch.view.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieswatch.adapters.GenreMovieAdapter
import kotlinx.android.synthetic.main.fragment_tab.view.*
import kotlinx.android.synthetic.main.viewpod_actors.view.*

class GenreMoviesViewPod@JvmOverloads constructor(
    context: Context, attrs: AttributeSet?= null, defStyleAttr:Int = 0
): LinearLayout(context, attrs, defStyleAttr) {
    override fun onFinishInflate() {
        super.onFinishInflate()
    }
    fun setGenreMovieData(genreMovieAdapter: GenreMovieAdapter){
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvGenre.layoutManager = linearLayoutManager
        rvGenre.adapter = genreMovieAdapter
    }
}