package com.cleanarchitecture.app.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.cleanarchitecture.app.domain.model.Greeting

class GreetingViewModel : ViewModel() {
    // Observable list of greetings
    var itemsList by mutableStateOf(listOf<Greeting>())
        private set

    // Load initial greetings into the list (this could also come from a repository)
    fun loadGreetings() {
        itemsList = listOf(
            Greeting("Hello from Clean Architecture!", "Greeting"),
            Greeting("Welcome to Compose!", "Information"),
            Greeting("Enjoy building your app!", "Motivation")
        )
    }

    // Add a new greeting to the list
    fun addGreeting(message: String, type: String) {
        itemsList = itemsList + Greeting(message, type)
    }
}
