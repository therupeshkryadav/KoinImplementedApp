// domain/usecase/AuthUseCase.kt
package com.cleanarchitecture.app.domain.usecase

import com.cleanarchitecture.app.data.source.repository.AuthRepository

class RegisterUserUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) =
        authRepository.registerUser(email, password)
}

class LoginUserUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) =
        authRepository.loginUser(email, password)
}
