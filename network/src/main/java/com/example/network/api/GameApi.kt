package com.example.network.api

import com.example.network.dto.request.CreateGameRequest
import com.example.network.dto.response.GameResponse
import com.example.network.dto.response.LeaderboardResponse
import retrofit2.http.*

interface GameApi {

    @GET("games")
    suspend fun getGames(): List<GameResponse>

    @POST("games")
    suspend fun createGame(
        @Body request: CreateGameRequest
    ): GameResponse

    @GET("games/{id}")
    suspend fun getGame(
        @Path("id") id: String
    ): GameResponse
}