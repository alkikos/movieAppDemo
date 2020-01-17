package com.raywenderlich.movieappforbacho.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.raywenderlich.movieappforbacho.data.model.Movie
import com.raywenderlich.movieappforbacho.data.repository.MovieRepository
import com.raywenderlich.movieappforbacho.data.repository.MovieRepositoryImpl

class MovieInfoViewModel(private val movieRepository: MovieRepositoryImpl =
                                    MovieRepositoryImpl()) : ViewModel() {

    fun getMovie(movieId: Int): LiveData<Movie> {
        return movieRepository.searchMovie(movieId)
    }
}