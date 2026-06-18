package com.example.gameapplication.domain.usecase.game

import com.example.gameapplication.domain.repository.GameRepository

class GetGamesUseCase(
    private val repository: GameRepository
) {
    suspend operator fun invoke() =
        repository.getGames()
}

class CreateGameUseCase(
    private val repository: GameRepository
) {
    suspend operator fun invoke(
        title: String,
        category: String,
        prize: String,
        from: String,
        to: String,
        description: String
    ) = repository.createGame(
        title,
        category,
        prize,
        from,
        to,
        description
    )
}