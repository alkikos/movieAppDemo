package com.raywenderlich.movieappforbacho.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView

import com.raywenderlich.movieappforbacho.R
import com.raywenderlich.movieappforbacho.adapter.CastAdapter
import com.raywenderlich.movieappforbacho.data.model.Cast
import com.raywenderlich.movieappforbacho.viewmodel.MovieCastViewModel


class MovieCastFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    //implement later
    val movieID = 20
    lateinit var cast: LiveData<Cast>
    lateinit var movieCastviewModel: MovieCastViewModel
    lateinit var recyclerView: RecyclerView
    private var adapter = CastAdapter(Cast(mutableListOf(), null))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieCastviewModel = ViewModelProviders.of(this).get(MovieCastViewModel::class.java)
        cast = movieCastviewModel.getCast(movieID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        recyclerView = view!!.findViewById(R.id.cast_list_recyclerview)
        recyclerView.adapter = adapter
        return inflater.inflate(R.layout.fragment_movie_cast, container, false)
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
        cast.observe(this, Observer {
            adapter.setCast(it)
        })

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
            MovieCastFragment()
    }
}
