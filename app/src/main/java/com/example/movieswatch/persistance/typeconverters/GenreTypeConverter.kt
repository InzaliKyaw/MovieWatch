package com.example.movieswatch.persistance.typeconverters

import androidx.room.TypeConverter
import com.example.movieswatch.data.vos.GenresVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreTypeConverter {
    @TypeConverter
    fun toString(genresVOList: ArrayList<GenresVO>):String{
        return Gson().toJson(genresVOList)
    }

    @TypeConverter
    fun toGenreList(genresListJsonString: String):ArrayList<GenresVO>{
        val genresListType = object : TypeToken<ArrayList<GenresVO>>(){}.type
        return Gson().fromJson(genresListJsonString,genresListType)
    }
}