package com.example.movieswatch.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieswatch.R
import com.example.movieswatch.data.vos.ItemsVO
import com.example.movieswatch.data.vos.PopularityResultsVO
import com.example.movieswatch.view.viewholder.GenreViewHolder

class GenreMovieAdapter():RecyclerView.Adapter<GenreViewHolder>(){

    var mData:List<PopularityResultsVO> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_movie,parent,false)
        return GenreViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }


    fun setNewData(data:MutableList<PopularityResultsVO>){
        mData = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bindGenreMoviews(mData[position])
    }
}