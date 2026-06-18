package com.example.network.api

data class NetworkApi(
    val authApi: AuthApi,
    val gameApi: GameApi,
    val userApi: UserApi
)