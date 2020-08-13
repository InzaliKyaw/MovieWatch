package com.example.movieswatch.mvp.view

import com.example.movieswatch.data.vos.CastVO
import com.example.movieswatch.data.vos.CrewVO
import com.example.movieswatch.network.responses.GetMovieDetailResponse
import com.example.movieswatch.persistance.daos.MovieDetailResponseDao

interface DetailView {
    fun displayActorList(actorList: List<CastVO>)
    fun displayCrewList(crewList: List<CrewVO>)
    fun displayDetail(movieDetail:GetMovieDetailResponse?)
}