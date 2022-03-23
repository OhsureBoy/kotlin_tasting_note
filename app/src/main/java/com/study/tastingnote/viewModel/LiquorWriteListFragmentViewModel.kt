package com.study.tastingnote.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.tastingnote.data.room.Liquor
import com.study.tastingnote.data.room.LiquorDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LiquorWriteListFragmentViewModel(private var roomDB : LiquorDao) : ViewModel(){

    val liveWriteTrackList: MutableLiveData<List<Liquor>> by lazy{
        MutableLiveData<List<Liquor>>()
    }

    fun getWriteTrackList(){
        viewModelScope.launch(Dispatchers.Default) {
            val writeTrackList : List<Liquor> = roomDB.getAll()
            Log.e("TAG", "getWriteTrackList: $writeTrackList")
            liveWriteTrackList.postValue(writeTrackList)
        }
    }
}