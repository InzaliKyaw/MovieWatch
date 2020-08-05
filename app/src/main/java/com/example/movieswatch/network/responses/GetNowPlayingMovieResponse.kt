package com.example.movieswatch.network.responses

import com.example.movieswatch.data.vos.PopularityResultsVO

data class GetNowPlayingMovieResponse (
    var results: ArrayList<PopularityResultsVO> ?= arrayListOf()
)