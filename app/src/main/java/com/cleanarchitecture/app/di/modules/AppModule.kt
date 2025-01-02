package com.cleanarchitecture.app.di.modules

import com.cleanarchitecture.app.data.repository.GreetingRepositoryImpl
import com.cleanarchitecture.app.domain.repository.GreetingRepository
import com.cleanarchitecture.app.domain.usecase.GetGreetingUseCase
import com.cleanarchitecture.app.presentation.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Provide the repository implementation
    single<GreetingRepository> { GreetingRepositoryImpl() }

    // Provide the use case
    single { GetGreetingUseCase(get()) }

    // Define the ViewModel
    viewModel { MainViewModel(get()) }

    // Provide other dependencies (e.g., ViewModel, etc.)
}