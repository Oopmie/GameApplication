package com.example.gameapplication.data.repository

import com.example.network.api.ApiService
import com.example.network.dto.ScheduledGameDto

class ScheduleRepositoryImpl(
    private val api: ApiService
) {

    suspend fun getScheduled(userId: String) =
        api.getScheduled(userId)

    suspend fun addScheduled(game: ScheduledGameDto) =
        api.addScheduled(game)
}