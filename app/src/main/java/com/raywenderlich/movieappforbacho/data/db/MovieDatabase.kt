package com.raywenderlich.movieappforbacho.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raywenderlich.movieappforbacho.data.model.Cast
import com.raywenderlich.movieappforbacho.data.model.Movie

@Database(entities = arrayOf(Movie::class, Cast::class), version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private var instance: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase {
            if(instance == null) {

                instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "Movie and Cast"
                ).build()
            }
            return instance as MovieDatabase
        }

    }
}