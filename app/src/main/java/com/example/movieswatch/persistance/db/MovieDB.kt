package com.example.movieswatch.persistance.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movieswatch.data.vos.*
import com.example.movieswatch.network.responses.GetMovieDetailResponse
import com.example.movieswatch.persistance.daos.*
import com.example.movieswatch.persistance.typeconverters.*


@Database(
    entities = [CastVO::class, CrewVO::class, GenresVO::class, ItemsVO::class, KnownForVO::class, PopularityResultsVO::class, PopularPersonResultsVO::class, GetMovieDetailResponse::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(
    GenresIdTypeConverter::class,
    GenreTypeConverter::class,
    KnownForTypeConverter::class,
    OriginalCountriesTypeConverter::class,
    ProductionCompanyTypeConverter::class,
    ProductionCountriesTypeConverter::class,
    SpokenLanguageTypeConverter::class
)
abstract class MovieDB : RoomDatabase() {
    companion object {
        val DB_NAME = "MOVIE_WATCH.DB"
        var dbInstance: MovieDB? = null
        fun getDBInstance(context: Context): MovieDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, MovieDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .build()

                }
            }
            val i = dbInstance
            return i!!
        }
    }

    abstract fun castDao(): CastDao
    abstract fun crewDao(): CrewDao
    abstract fun genresDao(): GenresDao
    abstract fun itemDao(): ItemDao
    abstract fun personKnownForDao(): PersonKnownForDao
    abstract fun popularMovieResultsDao(): PopularMovieResultDao
    abstract fun popularPersonDao(): PopularPersonDao
    abstract fun movieDetailDao(): MovieDetailResponseDao
    abstract fun allGenreDao():AllGenreDao

}