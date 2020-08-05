package com.example.movieswatch.persistance.typeconverters

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class OriginalCountriesTypeConverter {
    @TypeConverter
    fun toString(originalCountriesList: ArrayList<String>):String{
        return Gson().toJson(originalCountriesList)
    }

    @TypeConverter
    fun toOriginalCountriesList(originalCountriesListJsonString: String):ArrayList<String>{
        val originalCountriesListListType = object : TypeToken<ArrayList<String>>(){}.type
        return Gson().fromJson(originalCountriesListJsonString,originalCountriesListListType)
    }
}