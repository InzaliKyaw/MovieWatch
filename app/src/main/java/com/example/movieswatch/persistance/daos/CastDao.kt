package com.example.movieswatch.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movieswatch.data.vos.CastVO

@Dao
interface CastDao {
    @Query("SELECT * FROM `cast_vo` ")
    fun getAllCast():LiveData<List<CastVO>>

    @Query("DELETE FROM `cast_vo`")
    fun deleteAllCast()

    @Delete
    fun deleteCast(castVO: CastVO)

    @Insert
    fun insertCast(castVO: CastVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insetCastList(castVOList: List<CastVO>)
}