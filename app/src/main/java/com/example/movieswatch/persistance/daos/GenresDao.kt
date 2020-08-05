package com.example.movieswatch.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movieswatch.data.vos.GenresVO

@Dao
interface GenresDao {
    @Query("SELECT * FROM `genres` ")
    fun getAllGenre():LiveData<List<GenresVO>>

    @Query("DELETE FROM `genres`")
    fun deleteAllGenre()

    @Delete
    fun deleteGenre(genresVO: GenresVO)

    @Insert
    fun insertGenre(genresVO: GenresVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenreList(genreList: List<GenresVO>)
}