package com.example.movieswatch.network.responses

import com.example.movieswatch.data.vos.ItemsVO
import com.google.gson.annotations.SerializedName

data class GetLists (

    @SerializedName("created_by")
    var createdBy:String,

    @SerializedName("description")
    var description:String,

    @SerializedName("favorite_count")
    var favoriteCount:Int,

    @SerializedName("id")
    var id:String,

    @SerializedName("items")
    var items:ArrayList<ItemsVO> ?= arrayListOf(),

    @SerializedName("item_count")
    var itemCount:Int,

    @SerializedName("iso_639_1")
    var iso639:String,

    @SerializedName("name")
    var name:String,

    @SerializedName("poster_path")
    var posterPath:String
)