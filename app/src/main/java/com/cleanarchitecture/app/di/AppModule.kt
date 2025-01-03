package com.cleanarchitecture.app.di

import com.cleanarchitecture.app.di.modules.dataModule
import com.cleanarchitecture.app.di.modules.domainModule
import com.cleanarchitecture.app.di.modules.presentationModule
import org.koin.dsl.module

val appModule = module {
    includes(dataModule, domainModule, presentationModule)
}
