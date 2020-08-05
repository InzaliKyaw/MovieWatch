package com.example.movieswatch.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movieswatch.data.vos.CrewVO

@Dao
interface CrewDao {
    @Query("SELECT * FROM `crewVO` ")
    fun getAllCrew():LiveData<List<CrewVO>>

    @Query("DELETE FROM `crewVO`")
    fun deleteAllCrew()

    @Delete
    fun deleteCrew(crewVO: CrewVO)

    @Insert
    fun insertCrew(crewVO: CrewVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCrewList(crewVOList:List<CrewVO>)
}