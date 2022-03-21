package com.study.tastingnote.data.model

import com.google.gson.annotations.SerializedName

data class LiquorResponse(
    @SerializedName(value = "resultCount")
    val resultCount: Int,
    @SerializedName(value = "results")
    val results: ArrayList<TrackResult>
)