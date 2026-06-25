package com.example.network.dto

data class GameDto(
    val id: String? = null,
    val userId: String,
    val type: String, // "circle" / "image"
    val points: Int,
    val isWin: Boolean,
    val createdAt: String
)