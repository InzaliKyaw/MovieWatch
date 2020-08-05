package com.example.movieswatch.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieswatch.data.vos.PopularPersonResultsVO
import com.example.movieswatch.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_actor.view.*

class ActorViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    fun bindActor(actorList:PopularPersonResultsVO)
    {
        var imageUrl:String = IMAGE_BASE_URL +"original"+actorList.profilePath
        Glide.with(itemView)
            .load(imageUrl)
            .into(itemView.actorImage)
        itemView.actorName.text = actorList.name
    }
}