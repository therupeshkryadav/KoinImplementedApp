// di/modules/AuthModule.kt
package com.cleanarchitecture.app.di.modules

import com.google.firebase.auth.FirebaseAuth
import org.koin.dsl.module

val authModule = module {
    single { FirebaseAuth.getInstance() }
}
