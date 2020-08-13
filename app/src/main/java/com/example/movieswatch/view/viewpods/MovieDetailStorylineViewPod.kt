package com.example.movieswatch.view.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.movieswatch.network.responses.GetMovieDetailResponse
import kotlinx.android.synthetic.main.viewpod_movie_story_line.view.*

class MovieDetailStorylineViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?= null, defStyleAttr:Int = 0
): LinearLayout(context, attrs, defStyleAttr) {
    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun bindMovies(data:GetMovieDetailResponse?){
        storyLine.text = data?.overview
    }

}