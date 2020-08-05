package com.example.movieswatch.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movieswatch.data.vos.PopularPersonResultsVO

@Dao
interface PopularPersonDao {
    @Query("SELECT * FROM `popular_person` ")
    fun getAllPopularPerson():LiveData<List<PopularPersonResultsVO>>

    @Query("DELETE FROM `popular_person`")
    fun deleteAllPopularPerson()

    @Delete
    fun deletePopularPerson(popularPersonResultsVO: PopularPersonResultsVO)

    @Insert
    fun insertPopularPerson(popularPersonResultsVO: PopularPersonResultsVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularPersonList(popularPersonListVO:List<PopularPersonResultsVO>)
}