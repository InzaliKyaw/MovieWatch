package com.example.movieswatch.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieswatch.R
import com.example.movieswatch.data.vos.PopularityResultsVO
import com.example.movieswatch.utils.IMAGE_BASE_URL
import com.example.movieswatch.view.viewholder.MoviePageViewHolder
import kotlinx.android.synthetic.main.item_page.view.*
import retrofit2.http.Tag


class MoviePagerAdapter(val imageList:List<PopularityResultsVO>): RecyclerView.Adapter<MoviePageViewHolder>() {

    private var Tag = "izk"

    private val colors = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePageViewHolder =
        MoviePageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))

    //get the size of color array
    override fun getItemCount():Int{
        return 4
    }

    //binding the screen with view
    override fun onBindViewHolder(holder: MoviePageViewHolder, position: Int) = holder.itemView.run {

        for(i in 0..3 ){
            val imageUrl = IMAGE_BASE_URL+"original"+imageList[position].posterPath
            val title = imageList[position].originalTitle
            val imgTemp:ArrayList<String> = arrayListOf()
            for (i in imageList){
                imgTemp.add(imageUrl)
            }


            if(position == 0){
                slideMovieTitle.text = title
                Glide.with(this)
                    .load(imageUrl)
                    .into(ivImage)

                container.setBackgroundResource(colors[position])
            }
            if(position == 1) {
                slideMovieTitle.text = title
                Glide.with(this)
                    .load(imageUrl)
                    .into(ivImage)

                container.setBackgroundResource(colors[position])
            }
            if(position == 2) {
                slideMovieTitle.text = title
                Glide.with(this)
                    .load(imageUrl)
                    .into(ivImage)

                container.setBackgroundResource(colors[position])
            }
            if(position == 3) {
                slideMovieTitle.text = title
                Glide.with(this)
                    .load(imageUrl)
                    .into(ivImage)
                container.setBackgroundResource(colors[position])
            }
        }

        }


}
