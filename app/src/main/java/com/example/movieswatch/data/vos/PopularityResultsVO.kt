package com.example.movieswatch.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_movie_results")
data class PopularityResultsVO (

    @PrimaryKey
    @ColumnInfo(name = "popular_movie_id")
    @SerializedName("id")
    var id:Int = 0,

    @SerializedName("popularity")
    var popularity:Double = 0.0,

    @SerializedName("vote_count")
    var voteCount:Int = 0,

    @SerializedName("video")
    var video:Boolean = false,

    //Url
    @SerializedName("poster_path")
    var posterPath:String = "",


    @SerializedName("adult")
    var adult:Boolean = false,

    //Url
    @SerializedName("backdrop_path")
    var backdropPath:String?="" ,

    @SerializedName("original_language")
    var originalLanguage:String = "",

    @SerializedName("original_title")
    var originalTitle:String = "",

    //Collection_must use list
    @SerializedName("genre_ids")
    var genreIds:ArrayList<Int> = arrayListOf(),

    @SerializedName("title")
    var title:String = "",

    @SerializedName("vote_average")
    var voteAverage:Double = 0.0,

    @SerializedName("overview")
    var overview:String = "",

    @SerializedName("release_date")
    var releaseDate:String = ""


)