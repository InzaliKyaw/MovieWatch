package com.example.movieswatch.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieswatch.R
import com.example.movieswatch.data.vos.CastVO
import com.example.movieswatch.view.viewholder.ActorMovieDetailViewHolder

class ActorMovieDetailAdapter():RecyclerView.Adapter<ActorMovieDetailViewHolder>() {

    var mData:MutableList<CastVO> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorMovieDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_actor,parent,
            false)
        return ActorMovieDetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setNewData(data:MutableList<CastVO>){
        mData = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ActorMovieDetailViewHolder, position: Int) {
        holder.bindActors(mData[position])
    }
}