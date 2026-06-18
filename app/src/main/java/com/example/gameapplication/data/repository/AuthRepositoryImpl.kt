package com.example.gameapplication.data.repository

import com.example.gameapplication.domain.repository.AuthRepository
import com.example.network.api.AuthApi
import com.example.network.dto.request.RegisterRequest
import com.example.network.storage.TokenStorage

class AuthRepositoryImpl(
    private val authApi: AuthApi,
    private val tokenStorage: TokenStorage
) : AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): String {

        val users = authApi.getUsers()

        val user = users.find {
            it.email == email && it.password == password
        } ?: throw Exception("User not found")

        tokenStorage.saveToken(user.token)

        return user.token
    }

    override suspend fun register(
        name: String,
        email: String,
        password: String,
        username: String,
        phone: String
    ): String {

        val response = authApi.register(
            RegisterRequest(
                name = name,
                email = email,
                password = password,
                username = username,
                phone = phone
            )
        )

        tokenStorage.saveToken(response.token)

        return response.token
    }
}