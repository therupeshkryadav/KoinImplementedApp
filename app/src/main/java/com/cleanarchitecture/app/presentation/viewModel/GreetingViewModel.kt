package com.cleanarchitecture.app.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleanarchitecture.app.domain.model.Greeting
import com.cleanarchitecture.app.domain.usecase.AddGreetingUseCase
import com.cleanarchitecture.app.domain.usecase.GetGreetingUseCase
import kotlinx.coroutines.launch

class GreetingViewModel(
    private val getGreetingsUseCase: GetGreetingUseCase,
    private val addGreetingUseCase: AddGreetingUseCase
) : ViewModel() {

    // Preloaded greetings
    private val preloadedGreetings = listOf(
        Greeting(message = "message 1", type = "type 1"),
        Greeting(message = "message 2", type = "type 2"),
        Greeting(message = "message 3", type = "type 3"),
        Greeting(message = "message 4", type = "type 4"),
        Greeting(message = "message 5", type = "type 5")
    )

    var greetings = mutableStateOf<List<Greeting>>(listOf())
        private set

    fun loadGreetings() {
        viewModelScope.launch {
            // Combine preloaded greetings with fetched greetings
            val fetchedGreetings = getGreetingsUseCase()
            greetings.value = preloadedGreetings + fetchedGreetings
        }
    }

    fun addGreeting(message: String, type: String) {
        viewModelScope.launch {
            val updatedList = addGreetingUseCase(message, type)
            greetings.value = updatedList
        }
    }
}
