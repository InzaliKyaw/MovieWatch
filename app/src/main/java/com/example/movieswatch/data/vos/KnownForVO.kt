package com.example.movieswatch.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "person_known_for")
data class KnownForVO(

    @PrimaryKey
    @ColumnInfo(name = "person_known_for_id")
    @SerializedName("id")
    var id: Int,

    @SerializedName("original_name")
    var originalName: String,

    @SerializedName("vote_count")
    var voteCount: Int,

    @SerializedName("release_date")
    var releaseDate: String,

    @SerializedName("video")
    var video: Boolean,

    @SerializedName("media_type")
    var mediaType: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("vote_average")
    var voteAverage: Double,

    @SerializedName("first_air_date")
    var firstAirDate: String,

    //
    @SerializedName("title")
    var title: String? = null,

    @SerializedName("genre_ids")
    var genreIds: ArrayList<Int> = arrayListOf(),

    //
    @SerializedName("original_title")
    var originalTitle: String? = null,

    @SerializedName("original_language")
    var originalLanguage: String,

    @SerializedName("adult")
    var adult: Boolean,

    @SerializedName("backdrop_path")
    var backdropPath: String?,

    @SerializedName("overview")
    var overview: String,

    @SerializedName("poster_path")
    var posterPath: String,

    @SerializedName("origin_country")
    var originalCountry: ArrayList<String> = arrayListOf()
)