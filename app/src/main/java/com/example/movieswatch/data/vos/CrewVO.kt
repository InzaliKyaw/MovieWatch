package com.example.movieswatch.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "crewVO")
data class CrewVO (

    @PrimaryKey
    @SerializedName("credit_id")
    var creditId:String,

    @SerializedName("department")
    var department:String,

    @SerializedName("gender")
    var gender:Int,

    @SerializedName("id")
    var id:Int,

    @SerializedName("job")
    var job:String,

    @SerializedName("name")
    var name:String,

    @SerializedName("profile_path")
    var profilePath:String?
)