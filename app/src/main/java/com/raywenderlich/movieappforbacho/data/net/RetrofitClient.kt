package com.raywenderlich.movieappforbacho.data.net

import com.raywenderlich.movieappforbacho.data.db.MovieCastDao
import com.raywenderlich.movieappforbacho.data.model.Cast
import com.raywenderlich.movieappforbacho.data.model.Movie
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//Retrofit-ის კლიენტი მნიშვნელოვანია რო იყოს სინგლტონ(Singlton) კლასი
class RetrofitClient {

    private val moviesApi: MoviesApi


    companion object {
        private const val API_KEY = "7fabd36d89902f10a7d0701c7d99188d"
        private const val TMDB_BASE_URL = "http://api.themoviedb.org/3/"
        const val TMDB_IMAGEURL = "https://image.tmdb.org/t/p/w500/"
    }

    init {
        //okhttp-ის გაუწერე HttpLoggingInterceptor რო რექუესთები და რესპონსები დაილოგოს ლოგქეთში
        //https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor
        val builder = OkHttpClient.Builder()
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(TMDB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        moviesApi = retrofit.create(MoviesApi::class.java)

    }

    fun searchMovies(query: String): Call<Movie> {
        return moviesApi.searchMovie(API_KEY, query)
    }

    fun searchCast(query: String): Call<Cast>{
        return moviesApi.searchMovieCast(API_KEY, query)
    }



}