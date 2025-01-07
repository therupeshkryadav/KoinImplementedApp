package com.cleanarchitecture.app.data.source.repository

import com.cleanarchitecture.app.domain.model.Greeting
import com.cleanarchitecture.app.domain.repository.GreetingRepository

class GreetingRepositoryImpl : GreetingRepository {

    private val greetingsList = mutableListOf<Greeting>(
        Greeting(message = "Happy Birthday! Wishing you all the best on your special day.", type = "Personal"),
        Greeting(message = "Don't forget about the team meeting scheduled for 3 PM today.", type = "Professional"),
        Greeting(message = "Your account balance has been updated. Please check your statement.", type = "Financial"),
        Greeting(message = "Your assignment is due tomorrow. Make sure to submit it on time.", type = "Educational"),
        Greeting(message = "Reminder: Your package will be delivered tomorrow.", type = "Others")
    )
// from where this list should come according to clean architecture

    override suspend fun getGreeting(): List<Greeting> {
        return greetingsList
    }

    override suspend fun addGreeting(greeting: Greeting) {
        greetingsList.add(greeting)
    }
}

