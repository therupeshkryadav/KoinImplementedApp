package com.cleanarchitecture.app.domain.usecase

import com.cleanarchitecture.app.domain.model.Greeting

class GetGreetingUseCase {
    operator fun invoke(): List<Greeting> {
        return listOf(
            Greeting("Hello from Clean Architecture!", "Greeting"),
            Greeting("Welcome to Compose!", "Information"),
            Greeting("Enjoy building your app!", "Motivation")
        )
    }
}

