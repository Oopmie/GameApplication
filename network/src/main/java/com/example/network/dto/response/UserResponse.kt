package com.example.network.dto.response

data class UserResponse(
    val id: String,
    val name: String,
    val email: String,
    val username: String,
    val phone: String,
    val token: String,
    val history: String,
    val notifications: String
)