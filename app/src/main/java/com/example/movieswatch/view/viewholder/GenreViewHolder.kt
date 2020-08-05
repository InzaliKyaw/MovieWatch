package com.example.movieswatch.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieswatch.data.vos.ItemsVO
import com.example.movieswatch.data.vos.PopularityResultsVO
import com.example.movieswatch.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_popular_movie.view.*

class GenreViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    fun bindGenreMoviews(popularList: PopularityResultsVO){
//        for (i in itemList.genreIds){
//            if (itemList.genreIds.get(i) == 28){
//                itemView.popularMovieTitle.text = itemList.title
//                itemView.popularRate.text = itemList.popularity.toString()
//            }
//        }
        var imageUrl:String = IMAGE_BASE_URL +"original"+popularList.posterPath
        Glide.with(itemView)
            .load(imageUrl)
            .into(itemView.popularMovieImage)
        itemView.popularMovieTitle.text = popularList.title
        itemView.popularRate.text = popularList.popularity.toString()
    }

}