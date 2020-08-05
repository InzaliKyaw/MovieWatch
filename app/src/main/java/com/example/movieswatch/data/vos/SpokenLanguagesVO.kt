package com.example.movieswatch.data.vos

import com.google.gson.annotations.SerializedName

data class SpokenLanguagesVO (

    @SerializedName("iso_639_1")
    var iso639:String,

    @SerializedName("name")
    var name:String
)