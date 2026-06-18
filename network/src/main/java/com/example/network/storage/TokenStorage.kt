package com.example.network.storage

class TokenStorage {

    private var token: String? = null

    fun saveToken(value: String) {
        token = value
    }

    fun getToken(): String? {
        return token
    }

    fun clearToken() {
        token = null
    }
}