package com.example.movieswatch.mvp.view

import com.example.movieswatch.data.vos.PopularityResultsVO

interface MainView {
   // fun displayProfileList(task:ArrayList<Task>)
    fun navigateToDetail()
    fun displayMoviesByGenre(movieList:List<PopularityResultsVO>)
}