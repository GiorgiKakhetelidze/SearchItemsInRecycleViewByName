package com.example.homework10.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DogCard(val img: Int, val title: String, val description: String) : Parcelable
