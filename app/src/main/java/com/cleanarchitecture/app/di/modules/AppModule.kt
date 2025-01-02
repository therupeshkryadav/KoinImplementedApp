package com.cleanarchitecture.app.di.modules

import com.cleanarchitecture.app.domain.usecase.AddGreetingUseCase
import com.cleanarchitecture.app.domain.usecase.GetGreetingUseCase
import com.cleanarchitecture.app.presentation.viewModel.GreetingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Define the use cases as singletons
    single { GetGreetingUseCase() }
    single { AddGreetingUseCase() }

    // Provide the ViewModel with dependencies (use cases)
    viewModel { GreetingViewModel(get(), get()) }
}
