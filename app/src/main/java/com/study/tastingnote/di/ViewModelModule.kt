package com.study.tastingnote.di

import com.study.tastingnote.viewModel.LiquorFragmentViewModel
import com.study.tastingnote.viewModel.LiquorWriteListFragmentViewModel
import com.study.tastingnote.viewModel.WriteTrackViewModel
import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
val viewModelModule = module {

    viewModel { LiquorFragmentViewModel(get(), get()) }
    viewModel { WriteTrackViewModel(get()) }
    viewModel { LiquorWriteListFragmentViewModel(get())}
}