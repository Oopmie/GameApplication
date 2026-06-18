package com.example.network.dto.request

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val username: String,
    val phone: String,
    val token: String = "default_token",
    val history: String = "",
    val notifications: String = ""
)