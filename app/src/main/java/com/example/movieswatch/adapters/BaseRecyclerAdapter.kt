package com.example.movieswatch.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.movieswatch.view.viewholder.BaseViewHolder

abstract class BaseRecyclerAdapter<T: BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {
    var mData : MutableList<W> = arrayListOf()
    override fun getItemCount(): Int {
        return mData.count()
    }
    fun setNewData(data:MutableList<W>) {
        mData = data
        notifyDataSetChanged()
    }
}