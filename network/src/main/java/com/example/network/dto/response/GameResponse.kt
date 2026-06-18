package com.example.network.dto.response

data class GameResponse(
    val id: String,
    val title: String,
    val category: String,
    val prize: String,
    val description: String
)