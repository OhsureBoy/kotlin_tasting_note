package com.study.tastingnote.di

import com.study.tastingnote.data.repository.TrackRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { TrackRepository(get()) }
}