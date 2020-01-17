package com.raywenderlich.movieappforbacho.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.raywenderlich.movieappforbacho.data.model.Cast
import com.raywenderlich.movieappforbacho.data.repository.MovieRepositoryImpl

class MovieCastViewModel(private val movieRepositoryImpl: MovieRepositoryImpl =
                                    MovieRepositoryImpl()): ViewModel() {



    fun getCast(movieId: Int): LiveData<Cast> {
        return movieRepositoryImpl.getCast(movieId)
    }
}