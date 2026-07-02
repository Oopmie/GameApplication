package com.example.network.storage

class TokenStorage {

    private var token: String? = null
    private var userId: String? = null
    private var username: String? = null
    private var email: String? = null

    fun saveUser(
        id: String?,
        username: String,
        email: String,
        token: String
    ) {
        this.userId = id
        this.username = username
        this.email = email
        this.token = token
        println("SAVED USER ID = $userId")
    }

    fun getToken(): String? = token

    fun getUserId(): String? = userId

    fun getUsername(): String? = username

    fun clearUser() {
        token = null
        userId = null
        username = null
        email = null
    }
}