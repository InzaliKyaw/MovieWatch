package com.example.movieswatch.network.responses

import com.example.movieswatch.data.vos.CastVO
import com.example.movieswatch.data.vos.CrewVO
import com.google.gson.annotations.SerializedName

data class GetMovieDetailActor (

    @SerializedName("id")
    var id:Int,

    @SerializedName("cast")
    var castVO:ArrayList<CastVO> = arrayListOf(),

    @SerializedName("crew")
    var crewVO:ArrayList<CrewVO> = arrayListOf()
)