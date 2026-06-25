package com.example.network.dto

data class UserDto(
    val id: String? = null,
    val name: String,
    val username: String,
    val email: String,
    val password: String,
    val token: String = ""
)