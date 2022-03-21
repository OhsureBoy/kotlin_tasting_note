package com.study.tastingnote.data.repository

import com.study.tastingnote.data.api.ApiService
import com.study.tastingnote.data.model.LiquorResponse

class TrackRepository(private val searchService: ApiService) : BaseRepository() {
    suspend fun searchTrack(term:String, entity:String, limit:Int, offset:Int): LiquorResponse =
        apiRequest { searchService.searchTrack(term,entity,limit,offset) }
}