package com.example.network.dto.request

data class CreateGameRequest(
    val title: String,
    val category: String,
    val prize: String,
    val from: String,
    val to: String,
    val description: String
)