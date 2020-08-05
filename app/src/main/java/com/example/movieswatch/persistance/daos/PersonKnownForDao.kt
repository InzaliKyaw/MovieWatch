package com.example.movieswatch.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movieswatch.data.vos.KnownForVO

@Dao
interface PersonKnownForDao {
    @Query("SELECT * FROM `person_known_for` ")
    fun getAllPersonKnownFor():LiveData<KnownForVO>

    @Query("DELETE FROM `person_known_for`")
    fun deleteAllPersonKnownFor()

    @Delete
    fun deletePersonKnownFor(knownForVO: KnownForVO)

    @Insert
    fun insertPersonKnownFor(knownForVO: KnownForVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPersonKnownFor(knownForVOList: List<KnownForVO>)
}