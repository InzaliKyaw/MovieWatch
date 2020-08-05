package com.example.movieswatch.persistance.typeconverters

import androidx.room.TypeConverter
import com.example.movieswatch.data.vos.ProductionCompanyVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductionCompanyTypeConverter {
    @TypeConverter
    fun toString(productionCompanyVOList: ArrayList<ProductionCompanyVO>):String{
        return Gson().toJson(productionCompanyVOList)
    }

    @TypeConverter
    fun toProductionCompanyList(productionCompanyListJsonString: String):ArrayList<ProductionCompanyVO>{
        val productionCompanyListType = object : TypeToken<ArrayList<ProductionCompanyVO>>(){}.type
        return Gson().fromJson(productionCompanyListJsonString,productionCompanyListType)
    }
}