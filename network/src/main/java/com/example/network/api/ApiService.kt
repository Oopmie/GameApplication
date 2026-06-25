package com.example.network.api

import com.example.network.dto.GameDto
import com.example.network.dto.ScheduledGameDto
import com.example.network.dto.UserDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    // USERS
    @GET("users")
    suspend fun getUsers(): List<UserDto>

    @POST("users")
    suspend fun register(@Body user: UserDto): UserDto


    // GAMES (для статистики)
    @GET("games")
    suspend fun getGames(@Query("userId") userId: String): List<GameDto>

    @POST("games")
    suspend fun addGame(@Body game: GameDto): GameDto


    // SCHEDULE
    @GET("scheduledGames")
    suspend fun getScheduled(@Query("userId") userId: String): List<ScheduledGameDto>

    @POST("scheduledGames")
    suspend fun addScheduled(
        @Body game: ScheduledGameDto
    )
}