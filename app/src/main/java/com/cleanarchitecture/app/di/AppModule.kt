package com.cleanarchitecture.app.di

import com.cleanarchitecture.app.data.source.repository.GreetingRepositoryImpl
import com.cleanarchitecture.app.domain.repository.GreetingRepository
import com.cleanarchitecture.app.domain.usecase.AddGreetingUseCase
import com.cleanarchitecture.app.domain.usecase.GetGreetingUseCase
import com.cleanarchitecture.app.presentation.viewModel.GreetingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Provide the GreetingRepository implementation
    single<GreetingRepository> { GreetingRepositoryImpl() }
    // Provide Use Cases
    single { GetGreetingUseCase(get()) }
    single { AddGreetingUseCase(get()) }

    // Provide ViewModel
    viewModel { GreetingViewModel(get(), get()) }
}
