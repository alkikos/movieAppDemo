package com.raywenderlich.movieappforbacho.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import com.raywenderlich.movieappforbacho.data.model.Movie

@Dao
interface MovieDao{

    @Query("SELECT * FROM Movie")
    fun loadAll(): LiveData<List<Movie>>

    @Query("SELECT * FROM Movie WHERE id = :movieId")
    fun loadMovieInfo(movieId: Int): Movie

    @Query("SELECT * FROM Movie WHERE id = :movieId")
    fun loadLiveMovieInfo(movieId: Int): LiveData<Movie>

    @Insert(onConflict = IGNORE)
    fun insertMovie(movie: Movie): Int

    @Update(onConflict = REPLACE)
    fun updateMovieInfo(movie: Movie)

    @Delete
    fun deleteMovieInfo(movie: Movie)


}