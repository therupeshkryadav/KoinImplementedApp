package com.cleanarchitecture.app.data.source.repository

import com.cleanarchitecture.app.domain.model.Greeting
import com.cleanarchitecture.app.domain.repository.GreetingRepository

class GreetingRepositoryImpl : GreetingRepository {

    private val greetingsList = mutableListOf<Greeting>(
        Greeting(message = "Preloaded message 1", type = "type 1"),
        Greeting(message = "Preloaded message 2", type = "type 2"),
        Greeting(message = "Preloaded message 3", type = "type 3"),
        Greeting(message = "Preloaded message 4", type = "type 4"),
        Greeting(message = "Preloaded message 5", type = "type 5")
    )
//    private val greetingsList = mutableListOf<Greeting>() // from where this list should come according to clean architecture

    override suspend fun getGreeting(): List<Greeting> {
        return greetingsList
    }

    override suspend fun addGreeting(greeting: Greeting) {
        greetingsList.add(greeting)
    }
}

