package com.example.movieswatch.persistance.typeconverters

import androidx.room.TypeConverter
import com.example.movieswatch.data.vos.ProductionCountriesVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductionCountriesTypeConverter {

    @TypeConverter
    fun toString(productionCountriesVOList: ArrayList<ProductionCountriesVO>):String{
        return Gson().toJson(productionCountriesVOList)
    }

    @TypeConverter
    fun toProductionCountriesList(productionCountriesListJsonString: String):ArrayList<ProductionCountriesVO>{
        val productionCountriesListType = object : TypeToken<ArrayList<ProductionCountriesVO>>(){}.type
        return Gson().fromJson(productionCountriesListJsonString,productionCountriesListType)
    }
}