package com.cleanarchitecture.app.presentation.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleanarchitecture.app.domain.usecase.GetGreetingUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val getGreetingUseCase: GetGreetingUseCase) : ViewModel() {

    // Change greetingMessage type to Greeting instead of String
    val greetingMessage = mutableStateOf("")

    init {
        getGreeting()
    }

    private fun getGreeting() {
        viewModelScope.launch {
            // Get Greeting object and extract the message
            val greeting = getGreetingUseCase.execute()
            greetingMessage.value = greeting.message
        }
    }
}
