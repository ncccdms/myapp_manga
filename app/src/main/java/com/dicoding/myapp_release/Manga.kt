package com.dicoding.myapp_release

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Manga(
    val name: String,
    val description : String,
    val photo: Int,
    val status: String,
    val genre: String,
    val read : String
) : Parcelable
