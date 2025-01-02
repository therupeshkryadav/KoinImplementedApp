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

    var greetings = mutableStateOf<List<Greeting>>(emptyList())
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
