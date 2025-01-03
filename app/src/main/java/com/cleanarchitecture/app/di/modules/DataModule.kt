package com.cleanarchitecture.app.di.modules

import com.cleanarchitecture.app.data.source.repository.GreetingRepositoryImpl
import com.cleanarchitecture.app.domain.repository.GreetingRepository
import org.koin.dsl.module

val dataModule = module {
    // Provide the GreetingRepository implementation
    single<GreetingRepository> { GreetingRepositoryImpl() }
}