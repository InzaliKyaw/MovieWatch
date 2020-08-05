package com.example.movieswatch.persistance.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenresIdTypeConverter {

    @TypeConverter
    fun toString(genresIdList: ArrayList<Int>):String{
        return Gson().toJson(genresIdList)
    }

    @TypeConverter
    fun toGenreIdList(genresIdListJsonString: String):ArrayList<Int>{
        val genresIdListType = object :TypeToken<ArrayList<Int>>(){}.type
        return Gson().fromJson(genresIdListJsonString,genresIdListType)
    }
}