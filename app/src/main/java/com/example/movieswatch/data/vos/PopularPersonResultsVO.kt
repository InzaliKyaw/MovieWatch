package com.example.movieswatch.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_person")
data class PopularPersonResultsVO (

    @PrimaryKey()
    @ColumnInfo(name = "popular_person_id")
    @SerializedName("id")
    var id:Int = 0,

    @SerializedName("popularity")
    var popularity:Double = 0.0,

    @SerializedName("known_for_department")
    var knownForDepartment:String,

    @SerializedName("gender")
    var gender:Int,


    @SerializedName("profile_path")
    var profilePath:String?,

    @SerializedName("adult")
    var adult:Boolean,

    @SerializedName("known_for")
    var knownForVO: ArrayList<KnownForVO> = arrayListOf(),

    @SerializedName("name")
    var name:String

)