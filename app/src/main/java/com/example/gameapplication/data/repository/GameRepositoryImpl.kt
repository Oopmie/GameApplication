package com.example.gameapplication.data.repository

import com.example.gameapplication.domain.repository.GameRepository
import com.example.network.api.GameApi
import com.example.network.dto.request.CreateGameRequest
import com.example.network.dto.response.GameResponse
import com.example.network.dto.response.LeaderboardResponse

class GameRepositoryImpl(
    private val gameApi: GameApi
) : GameRepository {

    override suspend fun getGames(): List<GameResponse> {
        return gameApi.getGames()
    }

    override suspend fun createGame(
        title: String,
        category: String,
        prize: String,
        from: String,
        to: String,
        description: String
    ): GameResponse {
        return gameApi.createGame(
            CreateGameRequest(
                title = title,
                category = category,
                prize = prize,
                from = from,
                to = to,
                description = description
            )
        )
    }

    override suspend fun getGame(
        id: String
    ): GameResponse {
        return gameApi.getGame(id)
    }
}