package com.example.movieswatch.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieswatch.data.vos.CrewVO
import com.example.movieswatch.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_actor.view.*

class CrewMovieDetailViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
    fun bindCrew(crewVO:CrewVO){
        itemView.actorName.text = crewVO.name
        var imageUrl:String = IMAGE_BASE_URL +"original"+crewVO.profilePath
        Glide.with(itemView)
            .load(imageUrl)
            .into(itemView.actorImage)
    }
}