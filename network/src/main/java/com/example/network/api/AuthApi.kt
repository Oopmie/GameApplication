package com.example.network.api

import com.example.network.dto.request.LoginRequest
import com.example.network.dto.request.RegisterRequest
import com.example.network.dto.response.AuthResponse
import com.example.network.dto.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {

    @GET("users")
    suspend fun getUsers(): List<UserResponse>

    @POST("users")
    suspend fun register(
        @Body request: RegisterRequest
    ): UserResponse
}