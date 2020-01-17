package com.raywenderlich.movieappforbacho.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout

import com.raywenderlich.movieappforbacho.R


class MovieDetailsFragment : Fragment() {

    lateinit var fragmentContainer: FrameLayout
    lateinit var movieInfoFragment: MovieInfoFragment
    lateinit var movieCastFragment: MovieCastFragment
    private var listener: OnFragmentInteractionListener? = null
    lateinit var infoButton: Button
    lateinit var castButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragments()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view?.let {
            fragmentContainer = it.findViewById(R.id.fragmet_info_container)
            castButton = it.findViewById(R.id.movie_cast_button)
            infoButton = it.findViewById(R.id.movie_info_button)
            castButton.setOnClickListener{
                startMovieCastFragment()
                castButton.isClickable = false

            }
            infoButton.setOnClickListener{
                startMovieInfoFragment()
                infoButton.isClickable = false

            }
        }
        return inflater.inflate(R.layout.fragment_movie_info, container, false)
    }


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

        startMovieInfoFragment()


    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        fun newInstance() =
            MovieDetailsFragment()
    }

    private fun initFragments() {
        movieCastFragment = MovieCastFragment.newInstance()
        movieInfoFragment = MovieInfoFragment.newInstance()


    }

    private fun startMovieInfoFragment() {
        activity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmet_info_container, movieInfoFragment)
            .disallowAddToBackStack()
            .commit()
    }

    private fun startMovieCastFragment() {
        activity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmet_info_container, movieCastFragment)
            .disallowAddToBackStack()
            .commit()
    }
}
