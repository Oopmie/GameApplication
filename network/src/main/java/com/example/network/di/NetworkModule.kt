package com.example.network.di

import com.example.network.api.AuthApi
import com.example.network.api.GameApi
import com.example.network.api.NetworkApi
import com.example.network.api.UserApi
import com.example.network.interceptor.AuthInterceptor
import com.example.network.storage.TokenStorage
import com.example.network.util.ApiConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    fun create(
        tokenStorage: TokenStorage
    ): NetworkApi {

        val loggingInterceptor =
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

        val authInterceptor =
            AuthInterceptor(tokenStorage)

        val client =
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(authInterceptor)
                .build()

        val retrofit =
            Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .client(client)
                .addConverterFactory(
                    GsonConverterFactory.create()
                )
                .build()

        return NetworkApi(
            authApi = retrofit.create(AuthApi::class.java),
            gameApi = retrofit.create(GameApi::class.java),
            userApi = retrofit.create(UserApi::class.java)
        )
    }
}