package com.raywenderlich.movieappforbacho

import android.app.Application
import com.raywenderlich.movieappforbacho.data.db.MovieDatabase


lateinit var db: MovieDatabase

class App : Application() {

    companion object {
        //never expose app instance as static field
        lateinit var INSTANCE: App
    }

    init {
        //აპლიკაციის კლასის კონსტრუქტორს ასე არ მიწვდე თუ რამე გინდა onCreate-ში დაწერე
        INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()
        db = MovieDatabase.getInstance(this)
        INSTANCE = this

    }
}