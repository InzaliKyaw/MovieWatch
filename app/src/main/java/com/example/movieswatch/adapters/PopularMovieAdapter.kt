package com.example.movieswatch.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieswatch.R
import com.example.movieswatch.data.vos.PopularityResultsVO
import com.example.movieswatch.delegates.MovieListDelegates
import com.example.movieswatch.view.viewholder.PopularMovieViewHolder

class PopularMovieAdapter(delegates: MovieListDelegates): RecyclerView.Adapter<PopularMovieViewHolder>() {

    var mData:MutableList<PopularityResultsVO> = arrayListOf()
    val mDelegate: MovieListDelegates = delegates

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_movie,parent,false)
        return PopularMovieViewHolder(view,mDelegate)
    }

    override fun getItemCount(): Int {
        return mData.size

    }

    fun setNewData(data:MutableList<PopularityResultsVO>){
        mData = data
        notifyDataSetChanged()
    }

//    fun appendNewData(data: List<PopularityResultsVO>){
//        mData.addAll(data)
//        notifyDataSetChanged()
//    }

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        holder.bindMovies(mData[position])

    }
}
