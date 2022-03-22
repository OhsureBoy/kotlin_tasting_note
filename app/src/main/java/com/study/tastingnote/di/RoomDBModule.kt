package com.study.tastingnote.di

import android.app.Application
import androidx.room.Room
import com.study.tastingnote.data.room.LiquorDao
import com.study.tastingnote.data.room.LiquorDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomDBModule = module {

    fun provideRoomDatabase(application: Application) : LiquorDataBase =
        Room.databaseBuilder(application, LiquorDataBase::class.java,"liquor-db")
            .build()

    fun provideFavoritesDao(database: LiquorDataBase): LiquorDao {
        return database.liquorsDao()
    }

    single { provideRoomDatabase(androidApplication()) }
    single { provideFavoritesDao(get()) }

}