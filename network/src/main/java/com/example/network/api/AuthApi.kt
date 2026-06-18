package com.example.network.api

import com.example.network.dto.request.LoginRequest
import com.example.network.dto.request.RegisterRequest
import com.example.network.dto.response.AuthResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {

    @POST("users")
    suspend fun register(
        @Body request: RegisterRequest
    ): AuthResponse

    @GET("users")
    suspend fun getUsers(): List<AuthResponse>
}