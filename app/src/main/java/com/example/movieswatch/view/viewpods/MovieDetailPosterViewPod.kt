package com.example.movieswatch.view.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.movieswatch.network.responses.GetMovieDetailResponse
import com.example.movieswatch.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.viewpod_movie_detail_poster.view.*

class MovieDetailPosterViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?= null, defStyleAttr:Int = 0
): LinearLayout(context, attrs, defStyleAttr) {
    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun bindMoviePoster(data:GetMovieDetailResponse?){

        detailMovieTitle.text = data?.originalTitle
        val imageUrl:String = IMAGE_BASE_URL +"original"+data?.backdropPath
        Glide.with(this)
            .load(imageUrl)
            .into(detailImage)

    }
}