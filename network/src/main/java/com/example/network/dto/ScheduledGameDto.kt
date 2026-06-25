package com.example.network.dto

data class ScheduledGameDto(
    val id: String? = null,
    val userId: String,
    val title: String,
    val dateTime: String,
    val status: String = "scheduled"
)