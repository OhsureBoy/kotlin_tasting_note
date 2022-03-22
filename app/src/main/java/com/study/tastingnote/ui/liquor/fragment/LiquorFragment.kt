package com.study.tastingnote.ui.liquor.fragment

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
import com.study.tastingnote.databinding.FragmentLiquorBinding
import com.study.tastingnote.viewModel.LiquorFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LiquorFragment : Fragment() {

    private lateinit var binding: FragmentLiquorBinding
    private val viewModel : LiquorFragmentViewModel by viewModel()
    private lateinit var trackAdapter: TrackAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_liquor, container, false)
        binding.lifecycleOwner = activity
        binding.viewModel = viewModel


        val trackRecyclerView: RecyclerView = binding.trackListRecyclerview
        val linearLayoutManager = LinearLayoutManager(context)
        trackRecyclerView.layoutManager = linearLayoutManager

        trackAdapter = TrackAdapter()
        trackAdapter.setTouchEndScroll(object: TrackAdapter.OnTouchEndScrollListener{
            override fun onTouchEndScroll() {
                viewModel.searchNextTrack()
            }
        })

        binding.trackListRecyclerview.adapter =trackAdapter



        viewModel.resetTrackList()
        viewModel.liveTrackList.observe(binding.lifecycleOwner!!,{
            Log.e("CHECK_TAG","track list change observed")
            trackAdapter.setTrackList(it)
        })
        viewModel.searchNextTrack()
        return binding.root
    }
}