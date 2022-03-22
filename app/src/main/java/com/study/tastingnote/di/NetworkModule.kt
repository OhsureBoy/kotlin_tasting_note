package com.study.tastingnote.di

import com.study.tastingnote.data.api.ApiService
import okhttp3.OkHttpClient
import org.koin.android.BuildConfig
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://itunes.apple.com/"

val networkModule: Module = module {

    fun provideOkHttpClient() =
        OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    fun provideSplashService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideSplashService(get()) }

}