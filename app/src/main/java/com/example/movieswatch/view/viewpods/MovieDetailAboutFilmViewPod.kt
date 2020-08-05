package com.example.movieswatch.view.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.movieswatch.network.responses.GetMovieDetailResponse
import kotlinx.android.synthetic.main.viewpod_movie_detail_about_films.view.*

class MovieDetailAboutFilmViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?= null, defStyleAttr:Int = 0
): LinearLayout(context, attrs, defStyleAttr) {
    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun bindAboutFilm(data: GetMovieDetailResponse){
        originalTitleTxT.text = data.originalTitle
        productionTxt.text = data.productionCompanyVOS.get(2).name
        descriptionTxt.text = data.overview    }
}