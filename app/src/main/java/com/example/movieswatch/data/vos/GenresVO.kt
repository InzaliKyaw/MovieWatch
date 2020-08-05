package com.example.movieswatch.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genres")
data class GenresVO (

    @PrimaryKey
    @ColumnInfo(name = "genres_id")
    @SerializedName("id")
    var id:Int,

    @SerializedName("name")
    var name:String
)