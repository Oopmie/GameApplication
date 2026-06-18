package com.example.gameapplication.domain.usecase

import com.example.gameapplication.domain.repository.UserRepository

class GetHistoryUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(
        id: String
    ) = repository.getHistory(id)
}