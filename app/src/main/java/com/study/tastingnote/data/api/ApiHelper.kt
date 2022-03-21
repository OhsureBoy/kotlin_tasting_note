package com.study.tastingnote.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getLiquor() = apiService.getLiquor()
}