package com.study.tastingnote.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.tastingnote.data.model.TrackResult
import com.study.tastingnote.data.repository.TrackRepository
import com.study.tastingnote.data.room.Liquor
import com.study.tastingnote.data.room.LiquorDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LiquorFragmentViewModel(private val repository: TrackRepository, private val roomDB: LiquorDao) : ViewModel() {

    private val pagingLimit : Int = 20
    private var pagingOffset : Int = 0
    private val trackList = ArrayList<TrackResult>()

    val musicString: MutableLiveData<String> by lazy{
        MutableLiveData<String>().apply {
            value
        }
    }

    val liveTrackList: MutableLiveData<ArrayList<TrackResult>> by lazy{
        MutableLiveData<ArrayList<TrackResult>>()
    }
    val isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().apply {
            postValue(false)
        }
    }

    fun resetTrackList(){
        pagingOffset = 0
        trackList.clear()
    }


    fun searchNextTrack(){
        viewModelScope.launch(Dispatchers.IO) {
            isLoading.postValue(true)

            val favoriteTrackIds : List<Int> = roomDB.getAllId()

            val term = musicString.value
            val entity = "song"
            try {
                val response =
                    term?.let { repository.searchTrack(it, entity, pagingLimit, pagingOffset) }

                for(track in response!!.results){
                    var isWirteList = false
                    for(favoriteTrackId in favoriteTrackIds){//현재 track이 favorite이면 노란 별 체크
                        if(track.trackId==favoriteTrackId){
                            isWirteList = true
                            break
                        }
                    }
                    track.isWriteTrack = isWirteList
                    trackList.add(track)
                }
                liveTrackList.postValue(trackList)
                pagingOffset += pagingLimit

            } catch (e: Exception) {
                Log.e("ERROR_TAG", "searchTrack error : $e")
            }
            finally {
                isLoading.postValue(false)
            }
        }
    }
}