package com.example.movieswatch.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mData : T? = null
    abstract fun bindMovies(data:T)
}