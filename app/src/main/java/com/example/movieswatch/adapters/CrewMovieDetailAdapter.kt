package com.example.movieswatch.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieswatch.R
import com.example.movieswatch.data.vos.CrewVO
import com.example.movieswatch.view.viewholder.CrewMovieDetailViewHolder

class CrewMovieDetailAdapter() : RecyclerView.Adapter<CrewMovieDetailViewHolder>(){

    var mData:MutableList<CrewVO> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewMovieDetailViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_actor,parent,
                false)
            return CrewMovieDetailViewHolder(view)
        }

        override fun getItemCount(): Int {
            return mData.size
        }

        fun setNewData(data:MutableList<CrewVO>){
            mData = data
         notifyDataSetChanged()
        }

        override fun onBindViewHolder(holder: CrewMovieDetailViewHolder, position: Int) {
            holder.bindCrew(mData[position])
        }

}