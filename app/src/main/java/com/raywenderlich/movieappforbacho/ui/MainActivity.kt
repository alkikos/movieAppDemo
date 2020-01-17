package com.raywenderlich.movieappforbacho.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.lifecycle.ViewModelProviders
import com.raywenderlich.movieappforbacho.R
import com.raywenderlich.movieappforbacho.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){


    lateinit var mainViewModel: MainViewModel
    lateinit var movieListFragment: MovieListFragment
    var movieDetailsFragment: MovieDetailsFragment? = null
    lateinit var fragmentContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private fun initFragment(){
        fragmentContainer = fragment_container
        movieListFragment = MovieListFragment.newInstance()
        startMovieListFragment()

    }

    private fun startMovieListFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, movieListFragment)
            .disallowAddToBackStack()// ეს ორი რაღაც ერთად რო დაწერო
            .addToBackStack(null)// დაქრაშავს
            .commit()
    }

    override fun onBackPressed() {
        if(movieDetailsFragment != null) {
            supportFragmentManager
                .beginTransaction()
                .remove(movieListFragment!!)
                .commit()
            movieDetailsFragment = null
        }
        super.onBackPressed()
    }

    private fun startMoiveInfoFragment() {
        movieDetailsFragment = MovieDetailsFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, movieDetailsFragment!!, null)
            .commit()
        movieDetailsFragment = null
    }


}
