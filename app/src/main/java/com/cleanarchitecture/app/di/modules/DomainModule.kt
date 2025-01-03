package com.cleanarchitecture.app.di.modules

import com.cleanarchitecture.app.domain.usecase.AddGreetingUseCase
import com.cleanarchitecture.app.domain.usecase.GetGreetingUseCase
import org.koin.dsl.module

val domainModule = module {
    // Provide Use Cases
    single { GetGreetingUseCase(get()) }
    single { AddGreetingUseCase(get()) }
}