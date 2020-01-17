package com.raywenderlich.movieappforbacho.data.model


import com.google.gson.annotations.SerializedName

data class Actor(
    var adult: Boolean,
    @SerializedName("also_known_as")
    var alsoKnownAs: List<String>,
    var biography: String,
    var birthday: String,
    var deathday: Any,
    var gender: Int,
    var homepage: Any,
    var id: Int,
    @SerializedName("imdb_id")
    var imdbId: String,
    @SerializedName("known_for_department")
    var knownForDepartment: String,
    var name: String,
    @SerializedName("place_of_birth")
    var placeOfBirth: String,
    var popularity: Double,
    @SerializedName("profile_path")
    var profilePath: String
)