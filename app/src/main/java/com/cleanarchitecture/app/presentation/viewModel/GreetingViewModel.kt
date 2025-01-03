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

    var greetings = mutableStateOf<List<Greeting>>(mutableListOf())

    // Load preloaded greetings when ViewModel is initialized
    fun loadGreetings() {
        viewModelScope.launch {
            // Get preloaded greetings from the repository
            val fetchedGreetings = getGreetingsUseCase()
            greetings.value = fetchedGreetings
        }
    }

    fun addGreeting(message: String, type: String) {
        viewModelScope.launch {
            addGreetingUseCase(message, type)
        }
    }
}
