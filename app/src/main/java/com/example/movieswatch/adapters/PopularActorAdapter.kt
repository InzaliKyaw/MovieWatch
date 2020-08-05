package com.example.movieswatch.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieswatch.R
import com.example.movieswatch.data.vos.PopularPersonResultsVO
import com.example.movieswatch.view.viewholder.ActorViewHolder

class PopularActorAdapter():RecyclerView.Adapter<ActorViewHolder>() {

    var mData:MutableList<PopularPersonResultsVO> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_actor,parent,false)
        return ActorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setNewData(data:MutableList<PopularPersonResultsVO>){
        mData = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bindActor(mData[position])
    }
}