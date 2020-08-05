package com.example.movieswatch.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "castVO")
data class CastVO(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("cast_id")
    var castId:Int,

    @SerializedName("character")
    var character:String,

    @SerializedName("credit_id")
    var creditId:String,

    @SerializedName("gender")
    var gender:Int,

    //personId(ForeignKey)
    @SerializedName("id")
    var id:Int,

    @SerializedName("name")
    var name:String,

    @SerializedName("order")
    var order:Int,

    @SerializedName("profile_path")
    var profilePath:String?

)