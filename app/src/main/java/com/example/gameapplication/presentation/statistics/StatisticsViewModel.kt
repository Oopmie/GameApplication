package com.example.gameapplication.presentation.statistics

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.api.ApiService
import com.example.network.storage.TokenStorage
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class StatisticsViewModel(
    private val api: ApiService,
    private val tokenStorage: TokenStorage
) : ViewModel() {

    private val _state = mutableStateOf(StatisticsState())
    val state: State<StatisticsState> = _state

    fun load() {
        viewModelScope.launch {
            try {
                val userId = tokenStorage.getUserId() ?: return@launch

                val games = api.getGames()
                    .filter { it.userId == userId }

                val scheduled = api.getScheduled()
                    .filter { it.userId == userId }

                val earnings = games.sumOf { it.points }

                val circleWins = games.count {
                    it.type == "circle" && it.isWin
                }

                val imageWins = games.count {
                    it.type == "image" && it.isWin
                }

                _state.value = StatisticsState(
                    earnings = earnings,
                    circleWins = circleWins,
                    imageWins = imageWins,
                    scheduledCount = scheduled.size
                )

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}