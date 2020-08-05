package com.example.movieswatch.network.responses

import com.example.movieswatch.data.vos.GenresVO
import com.google.gson.annotations.SerializedName

class GetGenreResponse {

    @SerializedName("genres")
    val genresVO:ArrayList<GenresVO> = arrayListOf()
}