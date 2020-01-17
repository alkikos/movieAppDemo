package com.raywenderlich.movieappforbacho.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class CastX(
    @SerializedName("cast_id")
    @Expose
    val castId: Int?,
    @Expose
    val character: String?,
    @Expose
    @SerializedName("credit_id")
    val creditId: String?,
    @Expose
    val gender: Int?,
    @Expose
    val id: Int?,
    @Expose
    val name: String?,
    @Expose
    val order: Int?,
    @Expose
    @SerializedName("profile_path")
    val profilePath: String?
)