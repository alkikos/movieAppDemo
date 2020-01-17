package com.raywenderlich.movieappforbacho.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.raywenderlich.movieappforbacho.R
import com.raywenderlich.movieappforbacho.data.model.Movie
import com.raywenderlich.movieappforbacho.viewmodel.MovieInfoViewModel



class MovieInfoFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null
    lateinit var movieInfoViewModel: MovieInfoViewModel
    // we will retrive movieId from movieList
    val movieId = 20
    lateinit var movie: LiveData<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieInfoViewModel = ViewModelProviders.of(this).get(MovieInfoViewModel::class.java)
        movie = movieInfoViewModel.getMovie(movieId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_movie_info, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")

        }

        movie.observe(this, Observer { movie ->
            view?.findViewById<TextView>(R.id.movie_info_title)?.text = movie.title
            //seasoni xo mxolod serialebs aqcvs?
            view?.findViewById<TextView>(R.id.movie_info_season)?.text = movie.title
            // amas mere gavaketeb
            view?.findViewById<TextView>(R.id.movie_info_genre)?.text = movie.genreIds.toString()
        })
    }


    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        fun newInstance() =
            MovieInfoFragment()
    }
}
