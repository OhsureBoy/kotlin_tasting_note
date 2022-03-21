package com.study.tastingnote

import android.app.Application
import androidx.room.Room
import com.study.tastingnote.data.room.LiquorDataBase

class ApplicationClass : Application(){

    override fun onCreate() {
        super.onCreate()

        Room.databaseBuilder(this, LiquorDataBase::class.java,"liquor-db")
            .build()
    }
}