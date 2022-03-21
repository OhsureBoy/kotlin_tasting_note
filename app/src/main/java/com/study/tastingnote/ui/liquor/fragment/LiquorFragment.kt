package com.study.tastingnote.ui.liquor.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.study.tastingnote.R
import com.study.tastingnote.databinding.FragmentLiquorBinding
import com.study.tastingnote.viewModel.LiquorFragmentViewModel

class LiquorFragment : Fragment() {

    private lateinit var binding: FragmentLiquorBinding
    private lateinit var viewModel : LiquorFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_liquor, container, false)
        viewModel = ViewModelProvider(this)[LiquorFragmentViewModel::class.java]
        binding.lifecycleOwner = activity
        binding.viewModel = viewModel

        viewModel.searchNextTrack()

        return binding.root
    }
}