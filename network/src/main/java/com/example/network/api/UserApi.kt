package com.example.network.api

import com.example.network.dto.response.GameResponse
import com.example.network.dto.response.NotificationResponse
import com.example.network.dto.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("users/{id}")
    suspend fun getProfile(
        @Path("id") id: String
    ): UserResponse
}