package com.example.gameapplication.presentation.statistics

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.api.ApiService
import com.example.network.storage.TokenStorage
import kotlinx.coroutines.launch

class StatisticsViewModel(
    private val api: ApiService,
    private val tokenStorage: TokenStorage
) : ViewModel() {

    private val _state = mutableStateOf(StatisticsState())
    val state: State<StatisticsState> = _state

    fun load() {
        viewModelScope.launch {

            val userId = tokenStorage.getUserId() ?: return@launch

            val games = api.getGames(userId)
            val scheduled = api.getScheduled(userId)

            val earnings = games
                .filter { isThisWeek(it.createdAt) }
                .sumOf { it.points }

            val circleGames = games.count { it.type == "circle" && it.isWin }
            val imageGames = games.count { it.type == "image" && it.isWin }

            _state.value = StatisticsState(
                earnings = earnings,
                circleWins = circleGames,
                imageWins = imageGames,
                scheduledCount = scheduled.size
            )
        }
    }

    private fun isThisWeek(date: String): Boolean {
        return true
    }
}