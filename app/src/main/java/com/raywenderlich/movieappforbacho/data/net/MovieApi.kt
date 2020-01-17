package com.raywenderlich.movieappforbacho.data.net

import com.raywenderlich.movieappforbacho.data.model.Cast
import com.raywenderlich.movieappforbacho.data.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("discover/movie")
    fun getMovies(@Query("api_key") api_key: String): Call<Movie>

    @GET("search/movie")
    fun searchMovie(@Query("api_key") api_key: String, @Query("query") q: String): Call<Movie>

    @GET("search/movie")
    fun searchMovieCast(@Query("api_key") api_key: String, @Query("query") q: String): Call<Cast>
}