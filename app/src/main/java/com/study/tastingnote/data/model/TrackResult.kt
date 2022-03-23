package com.study.tastingnote.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrackResult (
    @SerializedName(value = "trackId")
    val trackId: Int,
    @SerializedName(value = "trackName")
    val trackName: String,
    @SerializedName(value = "collectionName")
    val collectionName: String,
    @SerializedName(value = "artistName")
    val artistName: String,
    @SerializedName(value = "artworkUrl60")
    val ImageUrl: String,

    var isWriteTrack : Boolean = false
): Parcelable