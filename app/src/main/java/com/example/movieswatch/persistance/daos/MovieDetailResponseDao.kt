package com.example.movieswatch.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movieswatch.network.responses.GetMovieDetailResponse

@Dao
interface MovieDetailResponseDao {
    @Query("SELECT * FROM `GetMovieDetailResponse` ")
    fun getAllMovieDetail(): LiveData<GetMovieDetailResponse?>

    @Query("SELECT * FROM `GetMovieDetailResponse`" )
    fun getMovieWithIdentity():LiveData<GetMovieDetailResponse?>

    @Query("DELETE FROM `GetMovieDetailResponse`")
    fun deleteAllMovieDetail()

    @Delete
    fun deleteMovieDetail(getMovieDetailResponse: GetMovieDetailResponse)

    @Insert
    fun insertPersonKnownFor(getMovieDetailResponse: GetMovieDetailResponse)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovieDetail(getMovieDetailResponseList: GetMovieDetailResponse)
}