package com.cleanarchitecture.app.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.cleanarchitecture.app.domain.model.Greeting
import com.cleanarchitecture.app.domain.usecase.AddGreetingUseCase
import com.cleanarchitecture.app.domain.usecase.GetGreetingUseCase

class GreetingViewModel(
    private val getGreetingsUseCase: GetGreetingUseCase,
    private val addGreetingUseCase: AddGreetingUseCase
) : ViewModel() {

    var greetings = mutableStateOf(listOf<Greeting>())
        private set

    fun loadGreetings() {
        greetings.value = getGreetingsUseCase()
    }

    fun addGreeting(message: String, type: String) {
        // Add a new greeting and update the state
        val updatedList = addGreetingUseCase(message, type, greetings.value)
        greetings.value = updatedList
    }
}
