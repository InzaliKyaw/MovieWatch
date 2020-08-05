package com.example.movieswatch.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieswatch.R
import com.example.movieswatch.data.vos.PopularityResultsVO
import com.example.movieswatch.utils.IMAGE_BASE_URL
import com.example.movieswatch.view.viewholder.MoviePageViewHolder
import kotlinx.android.synthetic.main.item_page.view.*


class MoviePagerAdapter(val imageList:List<PopularityResultsVO>): RecyclerView.Adapter<MoviePageViewHolder>() {

    private val colors = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePageViewHolder =
        MoviePageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))

    //get the size of color array
    override fun getItemCount(): Int = Int.MAX_VALUE

    //binding the screen with view
    override fun onBindViewHolder(holder: MoviePageViewHolder, position: Int) = holder.itemView.run {


        val imageUrl = IMAGE_BASE_URL+"original"+imageList[position].posterPath
        val imgTemp:ArrayList<String> = arrayListOf()
        for (i in imageList){
            imgTemp.add(imageUrl)
        }


        if(position == 0){

            Glide.with(this)
                .load(imageUrl)
                .into(ivImage)
             //holder.bindMovies(imageList[position])
            container.setBackgroundResource(colors[position])
        }
        if(position == 1) {

            Glide.with(this)
                .load(imageUrl)
                .into(ivImage)
           // holder.bindMovies(imageList[position])
            //ivImage.setImageResource(R.drawable.lensballblue640)
            container.setBackgroundResource(colors[position])
        }
        if(position == 2) {

            Glide.with(this)
                .load(imageUrl)
                .into(ivImage)
            //holder.bindMovies(imageList[position])
            //ivImage.setImageResource(R.drawable.lensballblue640)
            container.setBackgroundResource(colors[position])
        }
        if(position == 3) {

            Glide.with(this)
                .load(imageUrl)
                .into(ivImage)
            //holder.bindMovies(imageList[position])
            //ivImage.setImageResource(R.drawable.lensballblue640)
            container.setBackgroundResource(colors[position])
        }
    }
}
