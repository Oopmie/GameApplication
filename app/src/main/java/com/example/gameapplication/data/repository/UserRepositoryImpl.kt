//package com.example.gameapplication.data.repository
//
//import com.example.gameapplication.domain.repository.UserRepository
//import com.example.network.api.UserApi
//import com.example.network.dto.response.GameResponse
//import com.example.network.dto.response.NotificationResponse
//import com.example.network.dto.response.UserResponse
//
//class UserRepositoryImpl(
//    private val userApi: UserApi
//) : UserRepository {
//
//    override suspend fun getProfile(
//        id: String
//    ): UserResponse {
//        return userApi.getProfile(id)
//    }
//
//    override suspend fun getHistory(
//        id: String
//    ): String {
//        return userApi.getProfile(id).history
//    }
//
//    override suspend fun getNotifications(
//        id: String
//    ): String {
//        return userApi.getProfile(id).notifications
//    }
//}