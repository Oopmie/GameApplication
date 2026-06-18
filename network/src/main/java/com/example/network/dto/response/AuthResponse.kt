package com.example.network.dto.response

data class AuthResponse(
    val id: String,
    val name: String,
    val email: String,
    val password: String,
    val username: String,
    val phone: String,
    val token: String
)