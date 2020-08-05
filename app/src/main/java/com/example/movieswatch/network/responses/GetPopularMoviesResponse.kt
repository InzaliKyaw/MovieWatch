package com.example.movieswatch.network.responses

import com.example.movieswatch.data.vos.PopularityResultsVO
import com.google.gson.annotations.SerializedName

data class GetPopularMoviesResponse(

    //val kyg property and argument pyit
    //without val it will just argument not the property of class
    @SerializedName("page")
    val page:Int=0,

    @SerializedName("total_results")
    val totalResults:Int=0,

    @SerializedName("total_pages")
    val totalPages:Int=0,

    @SerializedName("results")
    val results:ArrayList<PopularityResultsVO> ?= arrayListOf() )