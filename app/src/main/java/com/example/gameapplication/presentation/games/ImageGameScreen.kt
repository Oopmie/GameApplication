package com.example.gameapplication.presentation.games

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gameapplication.R
import com.example.network.dto.GameDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ImageGameScreen(
    userId: String,
    api: GameApi,
    onFinish: () -> Unit
) {
    var taps by remember { mutableStateOf(0) }
    var isWin by remember { mutableStateOf(false) }

    val images = listOf(
        R.drawable.google,
        R.drawable.facebook,
        R.drawable.hamburger
    )

    val randomImage = remember { images.random() }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("IMAGE GAME", fontWeight = FontWeight.Bold)

        Image(
            painter = painterResource(randomImage),
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .clickable() {
                    taps++
                }
        )

        Text("Taps: $taps")

        Button (onClick = {
            isWin = taps >= 5

            CoroutineScope(Dispatchers.IO).launch {
                api.createGame(
                    GameDto(
                        userId = userId,
                        type = "image",
                        isWin = isWin,
                        points = taps * 2,
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