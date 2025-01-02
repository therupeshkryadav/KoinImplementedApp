package com.cleanarchitecture.app.domain.usecase

import com.cleanarchitecture.app.domain.model.Greeting
import com.cleanarchitecture.app.domain.repository.GreetingRepository

class GetGreetingUseCase(private val greetingRepository: GreetingRepository) {
    suspend operator fun invoke(): List<Greeting> {
        return greetingRepository.getGreeting()
    }
}

