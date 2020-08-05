package com.example.movieswatch.persistance.typeconverters

import androidx.room.TypeConverter
import com.example.movieswatch.data.vos.SpokenLanguagesVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SpokenLanguageTypeConverter {
    @TypeConverter
    fun toString(spokenLanguageListVO: ArrayList<SpokenLanguagesVO>):String{
        return Gson().toJson(spokenLanguageListVO)
    }

    @TypeConverter
    fun toSpokenLanguageList(spokenLanguageListJsonString: String):ArrayList<SpokenLanguagesVO>{
        val spokenLanguageListType = object : TypeToken<ArrayList<SpokenLanguagesVO>>(){}.type
        return Gson().fromJson(spokenLanguageListJsonString,spokenLanguageListType)
    }
}