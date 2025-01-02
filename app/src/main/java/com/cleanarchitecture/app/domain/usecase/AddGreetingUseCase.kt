package com.cleanarchitecture.app.domain.usecase

import com.cleanarchitecture.app.domain.model.Greeting

class AddGreetingUseCase {
    operator fun invoke(
        message: String,
        type: String,
        currentGreetings: List<Greeting>
    ): List<Greeting> {
        // Create a new Greeting object
        val newGreeting = Greeting(message, type)

        // Return a new list containing all previous greetings plus the new one
        return currentGreetings + newGreeting
    }
}
