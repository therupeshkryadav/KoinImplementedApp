package com.cleanarchitecture.app.presentation

import android.app.Application
import com.cleanarchitecture.app.di.modules.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinApplication:Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {
            androidContext(this@KoinApplication)
            modules(appModule)
        }
    }
}