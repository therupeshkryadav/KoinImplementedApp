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

    var greetings = mutableStateOf<List<Greeting>>(listOf(
        Greeting(message = "message 1", type = "type 1"),
        Greeting(message = "message 2", type = "type 2"),
        Greeting(message = "message 3", type = "type 3"),
        Greeting(message = "message 4", type = "type 4"),
        Greeting(message = "message 5", type = "type 5"),
        Greeting(message = "message 1", type = "type 1"),
        Greeting(message = "message 2", type = "type 2"),
        Greeting(message = "message 3", type = "type 3"),
        Greeting(message = "message 4", type = "type 4"),
        Greeting(message = "message 5", type = "type 5"),
        Greeting(message = "message 1", type = "type 1"),
        Greeting(message = "message 2", type = "type 2"),
        Greeting(message = "message 3", type = "type 3"),
        Greeting(message = "message 4", type = "type 4"),
        Greeting(message = "message 5", type = "type 5"),
        Greeting(message = "message 1", type = "type 1"),
        Greeting(message = "message 2", type = "type 2"),
        Greeting(message = "message 3", type = "type 3"),
        Greeting(message = "message 4", type = "type 4"),
        Greeting(message = "message 5", type = "type 5")
    ))
        private set

    fun loadGreetings() {
        viewModelScope.launch {
            val result = getGreetingsUseCase()
            greetings.value = result
        }
    }

    fun addGreeting(message: String, type: String) {
        viewModelScope.launch {
            val updatedList = addGreetingUseCase(message, type)
            greetings.value = updatedList
        }
    }
}
