package com.cleanarchitecture.app.domain.repository

import com.cleanarchitecture.app.domain.model.Greeting

interface GreetingRepository {
    suspend fun getGreeting(): Greeting
}
