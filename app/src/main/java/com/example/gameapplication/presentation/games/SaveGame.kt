package com.example.gameapplication.presentation.games

import com.example.network.api.ApiService
import com.example.network.dto.GameDto

suspend fun saveGame(
    api: ApiService,
    userId: String,
    score: Int,
    isWin: Boolean
) {
    println("GAME SAVE USER ID = $userId")
    api.addGame(
        GameDto(
            userId = userId.toString(),
            type = "circle",
            points = score,
            isWin = isWin,
            createdAt = System.currentTimeMillis().toString()
        )
    )
}