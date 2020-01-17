package com.raywenderlich.movieappforbacho.data.repository

import androidx.lifecycle.LiveData
import com.raywenderlich.movieappforbacho.data.model.Cast
import com.raywenderlich.movieappforbacho.data.model.Movie

interface MovieRepository {

    fun searchMovies(movieId: Int): LiveData<List<Movie>?>

    fun  searchMovie(movieId: Int): LiveData<Movie>

    fun getCast(movieId: Int): LiveData<Cast>



}