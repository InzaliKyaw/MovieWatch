package com.example.movieswatch.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieswatch.R
import com.example.movieswatch.data.vos.PopularityResultsVO
import com.example.movieswatch.delegates.MovieListDelegates
import com.example.movieswatch.view.viewholder.BasePopularMovieViewHolder
import com.example.movieswatch.view.viewholder.PopularMovieViewHolder

class PopularMovieAdapter(delegates: MovieListDelegates):BaseRecyclerAdapter<BasePopularMovieViewHolder,PopularityResultsVO>() {

    val mDelegate: MovieListDelegates = delegates

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_movie,parent,false)
        return PopularMovieViewHolder(view,mDelegate)
    }



    override fun onBindViewHolder(holder: BasePopularMovieViewHolder, position: Int) {
        holder.bindMovies(mData[position])

    }
    //    override fun getItemCount(): Int {
//        return mData.size
//
//    }



//    fun appendNewData(data: List<PopularityResultsVO>){
//        mData.addAll(data)
//        notifyDataSetChanged()
//    }
}
