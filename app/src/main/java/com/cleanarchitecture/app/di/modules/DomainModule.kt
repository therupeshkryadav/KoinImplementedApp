package com.cleanarchitecture.app.di.modules

import com.cleanarchitecture.app.domain.usecase.AddGreetingUseCase
import com.cleanarchitecture.app.domain.usecase.GetGreetingUseCase
import com.cleanarchitecture.app.domain.usecase.LoginUserUseCase
import com.cleanarchitecture.app.domain.usecase.RegisterUserUseCase
import org.koin.dsl.module

val domainModule = module {
    // Provide Use Cases
    single { GetGreetingUseCase(get()) }
    single { AddGreetingUseCase(get()) }
    factory { RegisterUserUseCase(get()) }
    factory { LoginUserUseCase(get()) }
}