package com.study.tastingnote.data.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "liquor_table")
data class Liquor(
    @PrimaryKey(autoGenerate = true) val trackId: Int,
    @ColumnInfo(name = "trackName") val trackName: String,
    @ColumnInfo(name = "collectionName") val collectionName: String,
    @ColumnInfo(name = "artistName") val artistName: String,
    @ColumnInfo(name = "writeText") val writeText: String,
    @ColumnInfo(name = "imgUrl") val imgUrl: String,
) : Parcelable