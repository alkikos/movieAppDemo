package com.raywenderlich.movieappforbacho.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.movieappforbacho.R


class MovieHolder(item: View) : RecyclerView.ViewHolder(item) {
    val title = item.findViewById<TextView>(R.id.movie_title)
    val image = item.findViewById<ImageView>(R.id.movie_image)
}
