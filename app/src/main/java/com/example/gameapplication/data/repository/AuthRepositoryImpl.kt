package com.example.gameapplication.data.repository

import com.example.gameapplication.domain.repository.AuthRepository
import com.example.network.api.ApiService
import com.example.network.dto.UserDto
import com.example.network.storage.TokenStorage

class AuthRepositoryImpl(
    private val api: ApiService,
    private val tokenStorage: TokenStorage
) : AuthRepository {

    override suspend fun login(email: String, password: String): String {

        val users = api.getUsers()

        val user = users.find {
            it.email == email && it.password == password
        } ?: throw Exception("Invalid credentials")

        tokenStorage.saveUser(
            id = user.id,
            username = user.username,
            email = user.email,
            token = user.token
        )

        return user.token
    }

    override suspend fun register(
        name: String,
        email: String,
        password: String,
        username: String,
        phone: String
    ): String {

        val newUser = api.register(
            UserDto(
                name = name,
                email = email,
                password = password,
                username = username,
                token = "default_token"
            )
        )

        tokenStorage.saveUser(
            id = newUser.id,
            username = newUser.username,
            email = newUser.email,
            token = newUser.token
        )

        return newUser.token
    }

    override fun clearToken() {
        tokenStorage.clearToken()
    }
}