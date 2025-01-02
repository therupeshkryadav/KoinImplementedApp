package com.cleanarchitecture.app.domain.usecase

import com.cleanarchitecture.app.domain.model.Greeting
import com.cleanarchitecture.app.domain.repository.GreetingRepository

class GetGreetingUseCase(private val greetingRepository: GreetingRepository) {
    suspend fun execute(): Greeting {
        return greetingRepository.getGreeting()
    }
}

