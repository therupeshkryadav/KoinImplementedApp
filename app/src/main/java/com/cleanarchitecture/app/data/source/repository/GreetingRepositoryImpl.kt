package com.cleanarchitecture.app.data.source.repository

import com.cleanarchitecture.app.domain.model.Greeting
import com.cleanarchitecture.app.domain.repository.GreetingRepository

class GreetingRepositoryImpl : GreetingRepository {
    private val greetingsList = mutableListOf<Greeting>()

    override suspend fun getGreeting(): List<Greeting> {
        return greetingsList
    }

    override suspend fun addGreeting(greeting: Greeting) {
        greetingsList.add(greeting)
    }
}

