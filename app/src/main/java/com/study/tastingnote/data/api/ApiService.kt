package com.study.tastingnote.data.api

import com.study.tastingnote.data.model.Liquor
import com.study.tastingnote.data.model.LiquorResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/search?")
    suspend fun searchTrack(
        @Query("term") term:String,
        @Query("entity") entity:String,
        @Query("limit") limit: Int,
        @Query("offset") offset:Int
    ) : Response<LiquorResponse>
}