package com.example.gameapplication.domain.usecase

import com.example.gameapplication.domain.repository.AuthRepository

class LoginUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ) = repository.login(email, password)
}

class RegisterUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        name: String,
        email: String,
        password: String,
        username: String,
        phone: String
    ) = repository.register(name, email, password, username, phone)
}