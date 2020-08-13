package com.example.movieswatch.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movieswatch.data.vos.PopularityResultsVO

@Dao
interface AllGenreDao {
    @Query("SELECT * FROM `popular_movie_results` ")
    fun getAllMovies(): LiveData<List<PopularityResultsVO>>

    @Query("SELECT * FROM popular_movie_results where genreIds =:genresId")
    fun getGenresMovies(genresId:Int) : LiveData<List<PopularityResultsVO>>

    @Query("DELETE FROM `popular_movie_results`")
    fun deleteAllMovies()

    @Delete
    fun deleteMovie(popularityResultsVO: PopularityResultsVO)

    @Insert
    fun insertMovie(popularityResultsVO: PopularityResultsVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenreList(allMovieList: List<PopularityResultsVO>)
}