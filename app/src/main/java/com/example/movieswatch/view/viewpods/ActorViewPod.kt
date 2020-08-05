package com.example.movieswatch.view.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieswatch.adapters.PopularActorAdapter
import kotlinx.android.synthetic.main.viewpod_actors.view.*

class ActorViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?= null, defStyleAttr:Int = 0
): LinearLayout(context, attrs, defStyleAttr) {
    override fun onFinishInflate() {
        super.onFinishInflate()
    }
    fun setActorMovieData(actorAdapter: PopularActorAdapter){
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvActors.layoutManager = linearLayoutManager
        rvActors.adapter = actorAdapter
    }
}