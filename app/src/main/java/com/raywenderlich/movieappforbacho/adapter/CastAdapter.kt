package com.raywenderlich.movieappforbacho.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.movieappforbacho.R
import com.raywenderlich.movieappforbacho.data.model.Cast

class CastAdapter(val cast: Cast) : RecyclerView.Adapter<CastAdaoterHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastAdaoterHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cast_info, parent, false)
        return CastAdaoterHolder(view)
    }

    override fun getItemCount(): Int {
      return cast.cast!!.size
    }

    override fun onBindViewHolder(holder: CastAdaoterHolder, position: Int) {
        holder.charName.text = cast.cast!!.get(position)!!.character
        holder.realName.text = cast.cast!!.get(position)!!.name
        //will imlement later
       // holder.image.setImageBitmap(cast.cast!!.get(position)!!.character)
        //holder.bDate.text = cast.cast!!.get(position)!!.birthDat

    }

    fun setCast(cast: Cast) {
        if(cast.cast!=null) {
            this.cast.cast!!.clear()
            this.cast.cast.addAll(cast.cast!!)
            notifyDataSetChanged()
        }
    }
}