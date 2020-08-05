package com.example.movieswatch.persistance.typeconverters

import androidx.room.TypeConverter
import com.example.movieswatch.data.vos.KnownForVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class KnownForTypeConverter {
    @TypeConverter
    fun toString(knownForVOList: ArrayList<KnownForVO>):String{
        return Gson().toJson(knownForVOList)
    }

    @TypeConverter
    fun toKnownForList(KnownForListJsonString: String):ArrayList<KnownForVO>{
        val KnownForListType = object : TypeToken<ArrayList<KnownForVO>>(){}.type
        return Gson().fromJson(KnownForListJsonString,KnownForListType)
    }
}