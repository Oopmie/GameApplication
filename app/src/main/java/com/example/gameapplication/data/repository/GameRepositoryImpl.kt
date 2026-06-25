package com.example.gameapplication.data.repository

import com.example.network.api.ApiService
import com.example.network.dto.GameDto

class GameRepositoryImpl(
    private val api: ApiService
) {

    suspend fun getGames(userId: String) =
        api.getGames(userId)

    suspend fun addGame(game: GameDto) =
        api.addGame(game)
}