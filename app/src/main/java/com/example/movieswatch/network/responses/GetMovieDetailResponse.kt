package com.example.movieswatch.network.responses

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieswatch.data.vos.GenresVO
import com.example.movieswatch.data.vos.ProductionCompanyVO
import com.example.movieswatch.data.vos.ProductionCountriesVO
import com.example.movieswatch.data.vos.SpokenLanguagesVO
import com.google.gson.annotations.SerializedName

@Entity
data class GetMovieDetailResponse(


    @SerializedName("adult")
    var adult: Boolean = false,

    @SerializedName("backdrop_path")
    var backdropPath: String = "",

    //check
    @SerializedName("belongs_to_collection")
    val belongsToCollection: Int? = null,

    @SerializedName("budget")
    var budget: Int = 0,

    @SerializedName("genres")
    var genres: ArrayList<GenresVO> = arrayListOf(),

    @SerializedName("homepage")
    var homepage: String = "",

    @PrimaryKey
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("imdb_id")
    var imdbId: String = "",

    @SerializedName("original_language")
    var originalLanguage: String = "",

    @SerializedName("original_title")
    var originalTitle: String = "",

    @SerializedName("overview")
    var overview: String = "",

    @SerializedName("popularity")
    var popularity: Double = 0.0,

    @SerializedName("poster_path")
    var posterPath: String = "",

    @SerializedName("production_companies")
    var productionCompanyVOS: ArrayList<ProductionCompanyVO> = arrayListOf(),

    @SerializedName("production_countries")
    var productionCountryVOS: ArrayList<ProductionCountriesVO> = arrayListOf(),

    @SerializedName("release_date")
    var releaseDate: String = "",

    @SerializedName("revenue")
    var revenue: Int = 0,

    @SerializedName("runtime")
    var runtime: Int = 0,

    @SerializedName("spoken_languages")
    var spokenLanguageVOS: ArrayList<SpokenLanguagesVO> = arrayListOf(),

    @SerializedName("status")
    var status: String = "",

    @SerializedName("tagline")
    var tagline: String = "",

    @SerializedName("title")
    var title: String = "",

    @SerializedName("video")
    var video: Boolean = false,

    @SerializedName("vote_average")
    var voteAverage: Double = 0.0,

    @SerializedName("vote_count")
    var voteCount: Int = 0


)