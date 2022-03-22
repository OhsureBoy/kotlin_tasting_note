package com.study.tastingnote

import android.app.Application
import com.study.tastingnote.di.networkModule
import com.study.tastingnote.di.repositoryModule
import com.study.tastingnote.di.roomDBModule
import com.study.tastingnote.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApplicationClass : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@ApplicationClass)
            modules(
                viewModelModule,
                networkModule,
                repositoryModule,
                roomDBModule
            )

        }
    }
}