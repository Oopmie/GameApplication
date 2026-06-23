package com.example.gameapplication.domain.repository

interface AuthRepository {

    suspend fun login(
        email: String,
        password: String
    ): String

    suspend fun register(
        name: String,
        email: String,
        password: String,
        username: String,
        phone: String
    ): String

    fun clearToken()
}