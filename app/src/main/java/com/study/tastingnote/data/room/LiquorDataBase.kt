package com.study.tastingnote.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Liquor::class], version = 1)
abstract class LiquorDataBase: RoomDatabase() {
    abstract fun liquorsDao(): LiquorDao
}