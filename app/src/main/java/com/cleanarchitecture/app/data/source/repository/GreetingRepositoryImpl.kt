package com.cleanarchitecture.app.data.source.repository

import com.cleanarchitecture.app.domain.model.Greeting
import com.cleanarchitecture.app.domain.repository.GreetingRepository

class GreetingRepositoryImpl : GreetingRepository {
    override suspend fun getGreeting(): Greeting {
        // For now, returning a static greeting message.
        // Later, you can modify this to fetch from a remote API or a local database.
        return Greeting(message = "Hello from Clean Architecture!","new")
    }
}
