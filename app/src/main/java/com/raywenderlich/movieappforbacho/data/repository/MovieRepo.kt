package com.raywenderlich.movieappforbacho.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.raywenderlich.movieappforbacho.data.db.MovieDao
import com.raywenderlich.movieappforbacho.data.db.MovieDatabase
import com.raywenderlich.movieappforbacho.data.model.Movie

class MovieRepo(context: Context) {
    private var db = MovieDatabase.getInstance(context)
    private var movieDao: MovieDao = db.movieDao()

    fun addMovie(movie: Movie): Int? {
        val newId = movieDao.insertMovie(movie)
        movie.id = newId
        return newId
    }

    fun createMovie(): Movie {
        return Movie()
    }

    val AllMovies: LiveData<List<Movie>>
    get() {
        return movieDao.loadAll()
    }
}