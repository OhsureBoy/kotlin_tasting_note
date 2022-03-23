package com.study.tastingnote.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.RoomDatabase
import com.study.tastingnote.data.room.Liquor
import com.study.tastingnote.data.room.LiquorDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WriteTrackViewModel(private val roomDB : LiquorDao) : ViewModel() {

    fun insertTrack(liquor: Liquor){
        viewModelScope.launch(Dispatchers.Default) {
            roomDB.insertTrack(liquor)
            Log.e("CHECK_TAG", "star clicked : ${liquor.trackName} 추가")
        }
    }
}