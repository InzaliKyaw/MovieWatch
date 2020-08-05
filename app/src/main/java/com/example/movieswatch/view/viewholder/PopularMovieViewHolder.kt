package com.example.movieswatch.view.viewholder

import android.util.Log.d
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieswatch.data.vos.PopularityResultsVO
import com.example.movieswatch.delegates.MovieListDelegates
import com.example.movieswatch.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_popular_movie.view.*

class PopularMovieViewHolder(itemView: View,delegates: MovieListDelegates) :RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            delegates.onTapMovie()
        }
    }
        fun bindMovies( popularMovieList: PopularityResultsVO){

            var TAG = "View Holder"
            var imageUrl:String = IMAGE_BASE_URL+"original"+popularMovieList.posterPath
            d(TAG,imageUrl)
            Glide.with(itemView)
                .load(imageUrl)
                .into(itemView.popularMovieImage)
            itemView.popularMovieTitle.text = popularMovieList.originalTitle
            itemView.popularRate.text = popularMovieList.popularity.toString()


        }
}