package com.ozantopuz.powerfulAndroid.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ozantopuz.powerfulAndroid.data.entity.Movie
import io.reactivex.Maybe

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie ORDER BY voteAverage DESC")
    fun getAll() : Maybe<List<Movie>>

    @Query("SELECT * FROM movie WHERE id = :id")
    fun getMovie(id : Int) : Maybe<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies : List<Movie>)
}