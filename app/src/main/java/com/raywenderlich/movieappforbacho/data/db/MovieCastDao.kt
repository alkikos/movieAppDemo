package com.raywenderlich.movieappforbacho.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.raywenderlich.movieappforbacho.data.model.Cast
import com.raywenderlich.movieappforbacho.data.model.Movie

interface MovieCastDao {

    @Query("SELECT * FROM `cast`")
    fun loadAll(): LiveData<List<Movie>>

    @Query("SELECT * FROM Movie WHERE id = :castId")
    fun loadMovieCastInfo(castId: Int): Movie

    @Query("SELECT * FROM Movie WHERE id = :castId")
    fun loadLiveMovieCast(castId: Int): LiveData<Movie>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovieCast(cast: Cast): Int

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMovieCast(cast: Cast)

    @Delete
    fun deleteMovieCast(cast: Cast)
}