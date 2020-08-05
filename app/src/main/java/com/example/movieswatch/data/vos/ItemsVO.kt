package com.example.movieswatch.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies_list")
data class ItemsVO (

    @PrimaryKey
    @ColumnInfo(name = "movies_id")
    @SerializedName("id")
    var id:Int,

    @SerializedName("vote_count")
    var voteCount:Int,

    @SerializedName("popularity")
    var popularity:Double,

    @SerializedName("video")
    var video:Boolean,

    @SerializedName("media_type")
    var mediaType:String,

    @SerializedName("vote_average")
    var voteAverage:Double,

    @SerializedName("title")
    var title:String,

    @SerializedName("release_date")
    var releaseDate:String,

    @SerializedName("original_language")
    var originalLanguage:String,

    @SerializedName("original_title")
    var originalTitle:String,

    @SerializedName("genre_ids")
    var genreIds:ArrayList<Int> = arrayListOf(),

    @SerializedName("backdrop_path")
    var backdropPath:String?,

    @SerializedName("adult")
    var adult:Boolean,

    @SerializedName("overview")
    var overview:String,

    @SerializedName("poster_path")
    var posterPath:String?

)