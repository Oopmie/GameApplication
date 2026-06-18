package com.example.gameapplication.domain.repository

import com.example.network.dto.response.GameResponse
import com.example.network.dto.response.LeaderboardResponse

interface GameRepository {

    suspend fun getGames(): List<GameResponse>

    suspend fun createGame(
        title: String,
        category: String,
        prize: String,
        from: String,
        to: String,
        description: String
    ): GameResponse

    suspend fun getGame(
        id: String
    ): GameResponse
}