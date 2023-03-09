package com.openwebinars.filmapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("rate")
    val rate: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("synopsis")
    val synopsis: String
): Parcelable
