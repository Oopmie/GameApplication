package com.example.gameapplication.presentation.games

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.network.dto.GameDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun CircleGameScreen(
    userId: String,
    api: GameApi,
    onFinish: () -> Unit
) {
    var score by remember { mutableStateOf(0) }
    var isWin by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("CIRCLE GAME", fontWeight = FontWeight.Bold)

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Blue, shape = CircleShape)
                .clickable {
                    score += 10
                }
        )

        Button (onClick = {
            isWin = score >= 50

            CoroutineScope(Dispatchers.IO).launch {
                api.createGame(
                    GameDto(
                        userId = userId,
                        type = "circle",
                        isWin = isWin,
                        points = score,
                        createdAt = System.currentTimeMillis().toString()
                    )
                )
            }

            onFinish()
        }) {
            Text("Finish Game")
        }
    }
}