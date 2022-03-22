package com.study.tastingnote.di

import com.study.tastingnote.viewModel.LiquorFragmentViewModel
import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
val viewModelModule = module {

    viewModel { LiquorFragmentViewModel(get(), get()) }

}