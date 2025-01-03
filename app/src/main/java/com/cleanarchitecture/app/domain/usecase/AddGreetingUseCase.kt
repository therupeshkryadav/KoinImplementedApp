package com.cleanarchitecture.app.domain.usecase

import com.cleanarchitecture.app.domain.model.Greeting
import com.cleanarchitecture.app.domain.repository.GreetingRepository

class AddGreetingUseCase(private val greetingRepository: GreetingRepository) {
    suspend operator fun invoke(message: String, type: String) {
        val newGreeting = Greeting(message = message, type = type)
        greetingRepository.addGreeting(newGreeting)
    }
}

