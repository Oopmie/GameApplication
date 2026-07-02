package com.example.gameapplication.presentation.games

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.network.api.ApiService
import com.example.network.dto.GameDto
import com.example.uikit.AppButton
import com.example.uikit.theme.GradientBot
import com.example.uikit.theme.GradientTop
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.sqrt
import kotlin.random.Random

@Composable
fun CircleGameScreen(
    userId: String,
    api: ApiService,
    onFinish: () -> Unit
) {
    var timeLeft by remember { mutableStateOf(30) }
    var score by remember { mutableStateOf(0) }
    var gameOver by remember { mutableStateOf(false) }

    val circleSizes = remember {
        listOf(180.dp, 160.dp, 140.dp, 120.dp, 100.dp, 80.dp, 60.dp, 45.dp, 30.dp)
    }

    val targetCenter = Offset(0f, 0f)
    val density = LocalDensity.current

    val circleOffsets = remember {
        mutableStateListOf<Offset>().apply {
            val radiiPx = circleSizes.map { size -> with(density) { (size / 2).toPx() } }
            val generated = generateNonOverlappingOffsets(radiiPx)
            addAll(generated)
        }
    }

    val isCircleInCenter = remember {
        mutableStateListOf<Boolean>().apply {
            circleSizes.forEach { _ -> add(false) }
        }
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        while (timeLeft > 0 && !gameOver) {
            delay(1000)
            timeLeft--
        }

        if (!gameOver) {
            api.addGame(
                GameDto(
                    userId = userId,
                    type = "circle",
                    isWin = false,
                    points = score,
                    createdAt = System.currentTimeMillis().toString()
                )
            )
            onFinish()
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Game Circle",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = TextPink,
            modifier = Modifier.padding(20.dp)
        )

        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(120.dp)
                .background(Brush.verticalGradient(listOf(GradientTop, GradientBot))),
            contentAlignment = Alignment.Center,

            ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Timer", color = White)

                Text(
                    text = "00:${timeLeft.toString().padStart(2, '0')}",
                    color = White,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .size(190.dp)
                    .border(2.dp, TextPink.copy(alpha = 0.3f), CircleShape)
                    .background(TextPink.copy(alpha = 0.05f), CircleShape)
            )

            circleSizes.forEachIndexed { index, size ->
                val isInCenter = isCircleInCenter[index]

                Box(
                    modifier = Modifier
                        .offset {
                            IntOffset(
                                circleOffsets[index].x.toInt(),
                                circleOffsets[index].y.toInt()
                            )
                        }
                        .size(size)
                        .clip(CircleShape)
                        .border(
                            width = 4.dp,
                            color = TextPink,
                            shape = CircleShape
                        )
                        .pointerInput(isInCenter) {
                            if (!isInCenter) {
                                detectDragGestures { change, dragAmount ->
                                    change.consume()

                                    val lastOffset = circleOffsets[index]
                                    val newOffset = Offset(
                                        lastOffset.x + dragAmount.x,
                                        lastOffset.y + dragAmount.y
                                    )
                                    circleOffsets[index] = newOffset

                                    val distance =
                                        sqrt((newOffset.x * newOffset.x + newOffset.y * newOffset.y).toDouble()).toFloat()

                                    if (distance < 50f) {
                                        circleOffsets[index] = targetCenter
                                        isCircleInCenter[index] = true
                                        score += 10

                                        if (isCircleInCenter.all { it }) {
                                            gameOver = true
                                            scope.launch {
                                                api.addGame(
                                                    GameDto(
                                                        userId = userId,
                                                        type = "circle",
                                                        isWin = true,
                                                        points = score,
                                                        createdAt = System.currentTimeMillis()
                                                            .toString()
                                                    )
                                                )
                                            }
                                            onFinish()
                                        }
                                    }
                                }
                            }
                        }
                )
            }

            AppButton(
                onClick = {
                    gameOver = true
                    scope.launch {
                        api.addGame(
                            GameDto(
                                userId = userId,
                                type = "circle",
                                isWin = false,
                                points = score,
                                createdAt = System.currentTimeMillis().toString()
                            )
                        )
                    }
                    onFinish()
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = 50.dp, end = 50.dp),
                text = "Surrender"
            )
        }
    }
}

private fun generateNonOverlappingOffsets(radii: List<Float>): List<Offset> {
    val result = mutableListOf<Offset>()

    val minX = -350f
    val maxX = 350f
    val minY = -500f
    val maxY = 500f

    val deadZoneRadius = 150f

    radii.forEachIndexed { index, currentRadius ->
        var foundPosition = false
        var attempts = 0
        var bestOffset = Offset(0f, 0f)

        while (!foundPosition && attempts < 200) {
            attempts++

            val randomX = Random.nextFloat() * (maxX - minX) + minX
            val randomY = Random.nextFloat() * (maxY - minY) + minY
            val potentialOffset = Offset(randomX, randomY)

            val distToCenter = sqrt((randomX * randomX + randomY * randomY).toDouble()).toFloat()
            if (distToCenter < (deadZoneRadius + currentRadius)) {
                continue
            }

            var hasOverlap = false
            for (i in 0 until result.size) {
                val existingOffset = result[i]
                val existingRadius = radii[i]

                val dx = potentialOffset.x - existingOffset.x
                val dy = potentialOffset.y - existingOffset.y
                val distance = sqrt((dx * dx + dy * dy).toDouble()).toFloat()

                if (distance < (currentRadius + existingRadius + 15f)) {
                    hasOverlap = true
                    break
                }
            }

            if (!hasOverlap) {
                bestOffset = potentialOffset
                foundPosition = true
            }
        }

        if (foundPosition) {
            result.add(bestOffset)
        } else {
            result.add(Offset(Random.nextFloat() * 200f - 100f, Random.nextFloat() * 200f - 100f))
        }
    }

    return result
}