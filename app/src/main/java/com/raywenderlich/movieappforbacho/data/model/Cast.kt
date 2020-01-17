package com.raywenderlich.movieappforbacho.data.model


import androidx.room.Entity
import com.google.gson.annotations.Expose

@Entity
data class Cast(
    @Expose
    val cast: MutableList<CastX>?,
    val id: Int?
)