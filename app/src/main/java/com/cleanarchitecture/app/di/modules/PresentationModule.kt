package com.cleanarchitecture.app.di.modules

import com.cleanarchitecture.app.presentation.viewModel.GreetingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    // Provide ViewModel
    viewModel { GreetingViewModel(get(), get()) }
}