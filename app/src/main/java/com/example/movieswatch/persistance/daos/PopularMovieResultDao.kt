package com.example.movieswatch.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movieswatch.data.vos.PopularityResultsVO

@Dao
interface PopularMovieResultDao {

    @Query("SELECT * FROM popular_movie_results")
    fun getAllPopularMovie():LiveData<List<PopularityResultsVO>>

    @Query("DELETE FROM popular_movie_results")
    fun deleteAll()

    @Delete
    fun deletePopularMovie(popularMovie:PopularityResultsVO)

    @Insert
    fun insertPopularMovie(popularMovie:PopularityResultsVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovieList(popularMovieList:List<PopularityResultsVO>)
}