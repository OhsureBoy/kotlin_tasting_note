package com.study.tastingnote.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "liquor_table")
data class Liquor(
    @PrimaryKey(autoGenerate = true) val liquorId: Int,
    @ColumnInfo(name = "liquorName") val liquorName: String,
    @ColumnInfo(name = "liquorADV") val liquorADV: String,
    @ColumnInfo(name = "liquorMRM") val liquorMRM: String,
    @ColumnInfo(name = "imgUrl") val imgUrl: String
)