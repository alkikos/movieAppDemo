package com.raywenderlich.movieappforbacho.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.movieappforbacho.R
import kotlinx.android.synthetic.main.cast_info.view.*

class CastAdaoterHolder(item: View): RecyclerView.ViewHolder(item) {
    val image = item.findViewById<ImageView>(R.id.cast_image)
    val realName = item.findViewById<TextView>(R.id.cast_real_name)
    val charName = item.findViewById<TextView>(R.id.cast_character_name)
    val bDate = item.findViewById<TextView>(R.id.cast_birth_date)
}