package com.example.movieswatch.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieswatch.data.vos.PopularityResultsVO

interface AllGenreDao {
    @Query("SELECT * FROM `popular_movie_results` ")
    fun getAllMovies(): LiveData<List<PopularityResultsVO>>

    @Query("SELECT * FROM popular_movie_results")
    fun getGenresMovies() : LiveData<List<PopularityResultsVO>>

    @Query("DELETE FROM `popular_movie_results`")
    fun deleteAllMovies()

    @Delete
    fun deleteMovie(popularityResultsVO: PopularityResultsVO)

    @Insert
    fun insertMovie(popularityResultsVO: PopularityResultsVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenreList(allMovieList: List<PopularityResultsVO>)
}