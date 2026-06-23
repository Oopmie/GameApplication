package com.example.gameapplication.data.local

import android.content.Context

class AppPreferences(context: Context) {

    private val prefs =
        context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    fun isFirstLaunch(): Boolean {
        return prefs.getBoolean("is_first_launch", true)
    }

    fun setFirstLaunchDone() {
        prefs.edit()
            .putBoolean("is_first_launch", false)
            .apply()
    }
}