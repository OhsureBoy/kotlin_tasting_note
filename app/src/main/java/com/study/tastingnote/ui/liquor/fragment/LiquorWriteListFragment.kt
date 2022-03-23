package com.study.tastingnote.ui.liquor.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.study.tastingnote.R
import com.study.tastingnote.adapter.TrackAdapter
import com.study.tastingnote.adapter.WriteTrackAdapter
import com.study.tastingnote.data.model.TrackResult
import com.study.tastingnote.data.room.Liquor
import com.study.tastingnote.databinding.FragmentLiquorWriteListBinding
import com.study.tastingnote.ui.liquor.WriteTrackActivity
import com.study.tastingnote.viewModel.LiquorWriteListFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LiquorWriteListFragment : Fragment() {
    private lateinit var binding: FragmentLiquorWriteListBinding
    private val viewModel : LiquorWriteListFragmentViewModel by viewModel()
    private lateinit var trackAdapter: WriteTrackAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_liquor_write_list, container, false)
        binding.lifecycleOwner = activity
        binding.viewModel = viewModel

        val trackRecyclerView: RecyclerView = binding.trackListRecyclerview
        val linearLayoutManager = LinearLayoutManager(context)
        trackRecyclerView.layoutManager = linearLayoutManager

        trackAdapter = WriteTrackAdapter()
        trackRecyclerView.adapter = trackAdapter

        viewModel.getWriteTrackList()
        setTrackListClickListener()

        viewModel.liveWriteTrackList.observe(binding.lifecycleOwner!!) {
            for (trackList in it) {
                val track: Liquor = Liquor(
                    trackList.trackId,
                    trackList.trackName,
                    trackList.collectionName,
                    trackList.artistName,
                    trackList.writeText,
                    trackList.imgUrl
                )
                Log.e("TAG", "onCreateView: " + trackList.writeText )
                trackAdapter.addWriteTrack(track)
            }
            trackAdapter.notifyDataSetChanged()
        }

        return binding.root
    }

    private fun setTrackListClickListener(){
//        trackAdapter.setTouchItem(object: TrackAdapter.OnItemClickListener {
//            override fun onItemClick(track: TrackResult, position: Int) {
//                Intent(activity, WriteTrackActivity::class.java).apply {
//                    putExtra("track", track)
//                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                }.run { startActivity(this) }
//            }
//        })

    }
}