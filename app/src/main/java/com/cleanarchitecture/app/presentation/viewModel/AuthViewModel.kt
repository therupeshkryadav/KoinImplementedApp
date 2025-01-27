// presentation/viewModel/AuthViewModel.kt
package com.cleanarchitecture.app.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleanarchitecture.app.domain.usecase.LoginUserUseCase
import com.cleanarchitecture.app.domain.usecase.RegisterUserUseCase
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val registerUserUseCase: RegisterUserUseCase,
    private val loginUserUseCase: LoginUserUseCase
) : ViewModel() {

    private val _user = MutableStateFlow<FirebaseUser?>(null)
    val user: StateFlow<FirebaseUser?> = _user

    fun registerUser(email: String, password: String) {
        viewModelScope.launch {
            val result = registerUserUseCase(email, password)
            _user.value = result
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            val result = loginUserUseCase(email, password)
            _user.value = result
        }
    }
}
