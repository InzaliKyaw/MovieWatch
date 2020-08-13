package com.example.movieswatch.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.movieswatch.mvp.view.DetailView

interface DetailPresenter {
   fun onUiReady(lifecycleOwner: LifecycleOwner,movieId:Int)
   fun initPresenter(view:DetailView)
}