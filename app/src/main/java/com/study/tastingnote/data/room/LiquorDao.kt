package com.study.tastingnote.data.room

import androidx.room.*

@Dao
interface LiquorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrack(vararg track: Liquor)

    @Query("SELECT * FROM liquor_table")
    fun getAll(): List<Liquor>

    @Query("SELECT liquorId FROM liquor_table")
    fun getAllId(): List<Int>

    @Delete
    fun delete(track: Liquor)
}