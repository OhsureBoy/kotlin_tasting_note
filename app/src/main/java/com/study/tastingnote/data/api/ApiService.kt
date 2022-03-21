package com.study.tastingnote.data.api

import com.study.tastingnote.data.model.Liquor
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getLiquor(): List<Liquor>
}