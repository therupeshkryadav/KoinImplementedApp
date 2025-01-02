package com.cleanarchitecture.app.di.modules

import com.cleanarchitecture.app.data.source.repository.GreetingRepositoryImpl
import com.cleanarchitecture.app.domain.repository.GreetingRepository
import com.cleanarchitecture.app.domain.usecase.GetGreetingUseCase

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Provide the repository implementation
    single<GreetingRepository> { GreetingRepositoryImpl() }

    // Provide the use case
    single { GetGreetingUseCase(get()) }

    // Provide other dependencies (e.g., ViewModel, etc.)
}