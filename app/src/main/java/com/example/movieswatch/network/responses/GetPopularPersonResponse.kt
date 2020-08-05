package com.example.movieswatch.network.responses

import com.example.movieswatch.data.vos.PopularPersonResultsVO
import com.google.gson.annotations.SerializedName

class GetPopularPersonResponse (
    @SerializedName("page")
    val page:Int=0,

    @SerializedName("total_results")
    val totalResults:Int=0,

    @SerializedName("total_pages")
    val totalPages:Int=0,

    @SerializedName("results")
    val results:ArrayList<PopularPersonResultsVO> ?= arrayListOf()
)