package com.example.movieswatch.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieswatch.data.vos.CastVO
import com.example.movieswatch.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_actor.view.*

class ActorMovieDetailViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

        fun bindActors(castVO:CastVO){
         itemView.actorName.text = castVO.name
            var imageUrl = IMAGE_BASE_URL+"original"+castVO.profilePath
            Glide.with(itemView)
                .load(imageUrl)
                .into(itemView.actorImage)
        }
}