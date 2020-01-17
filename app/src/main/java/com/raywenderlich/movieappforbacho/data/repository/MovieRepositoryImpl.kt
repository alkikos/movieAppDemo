package com.raywenderlich.movieappforbacho.data.repository

import androidx.lifecycle.LiveData
import com.raywenderlich.movieappforbacho.db
import com.raywenderlich.movieappforbacho.data.db.MovieDao
import com.raywenderlich.movieappforbacho.data.model.Cast
import com.raywenderlich.movieappforbacho.data.model.Movie
import com.raywenderlich.movieappforbacho.data.net.RetrofitClient

class MovieRepositoryImpl: MovieRepository {

    private val movieDao: MovieDao = db.movieDao()
    private val retrofitClient = RetrofitClient()


    override fun searchMovies(movieId: Int): LiveData<List<Movie>?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchMovie(movieId: Int): LiveData<Movie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun getCast(movieId: Int): LiveData<Cast> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}