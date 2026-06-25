package com.example.gameapplication.presentation.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.api.ApiService
import com.example.network.dto.ScheduledGameDto
import com.example.network.storage.TokenStorage
import kotlinx.coroutines.launch

class ScheduleViewModel(
    private val api: ApiService,
    private val tokenStorage: TokenStorage
) : ViewModel() {

    fun createGame(title: String, date: String) {
        viewModelScope.launch {

            val userId = tokenStorage.getUserId() ?: return@launch

            api.addScheduled(
                ScheduledGameDto(
                    userId = userId,
                    title = title,
                    dateTime = date,
                    status = "scheduled"
                )
            )
        }
    }
}