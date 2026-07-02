package com.example.gameapplication.presentation.games

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.GradientBot
import com.example.uikit.theme.GradientTop
import com.example.uikit.theme.TextPink
import com.example.uikit.theme.White
import kotlinx.coroutines.delay

@Composable
fun ImageGameScreen(
    onFinish: (score: Int) -> Unit
) {
    var timeLeft by remember { mutableStateOf(30) }
    var gameOver by remember { mutableStateOf(false) }
    var isWin by remember { mutableStateOf(false) }

    val context = LocalContext.current

    val correctOrder = remember { listOf(0, 1, 2, 3, 4, 5, 6, 7, 8) }
    val currentOrder = remember {
        mutableStateListOf<Int>().apply {
            addAll(correctOrder.shuffled())
        }
    }
    var selectedIndex by remember { mutableStateOf<Int?>(null) }

    LaunchedEffect(timeLeft, gameOver, isWin) {
        if (isWin) return@LaunchedEffect

        if (timeLeft <= 0 && !gameOver) {
            gameOver = true
            Toast.makeText(context, "Time's Up!", Toast.LENGTH_SHORT).show()
            delay(800)
            onFinish(0)
            return@LaunchedEffect
        }

        if (timeLeft > 0 && !gameOver) {
            delay(1000)
            timeLeft--
        }
    }

    LaunchedEffect(isWin) {
        if (isWin) {
            gameOver = true
            Toast.makeText(context, "Puzzle Solved!", Toast.LENGTH_SHORT).show()
            delay(800)
            onFinish(100)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Assemble Puzzle",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = TextPink,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 16.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(
                    Brush.verticalGradient(listOf(GradientTop, GradientBot)),
                    RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = when {
                        isWin -> "Victory!"
                        timeLeft <= 0 -> "Time's Up!"
                        else -> "Timer"
                    },
                    color = White,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "00:${timeLeft.toString().padStart(2, '0')}",
                    color = White,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .border(4.dp, TextPink, RoundedCornerShape(12.dp))
                .background(Color.White)
                .clip(RoundedCornerShape(12.dp)),
            horizontalArrangement = Arrangement.spacedBy(0.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            items(9) { gridIndex ->
                val pieceId = currentOrder[gridIndex]
                val isSelected = selectedIndex == gridIndex

                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .border(
                            width = if (isSelected) 4.dp else 0.dp,
                            color = if (isSelected) TextPink else Color.Transparent
                        )
                        .clickable(enabled = !gameOver) {
                            if (selectedIndex == null) {
                                selectedIndex = gridIndex
                            } else {
                                val firstGridIndex = selectedIndex!!

                                if (firstGridIndex != gridIndex) {
                                    val temp = currentOrder[firstGridIndex]
                                    currentOrder[firstGridIndex] = currentOrder[gridIndex]
                                    currentOrder[gridIndex] = temp

                                    if (currentOrder.toList() == correctOrder) {
                                        isWin = true
                                    }
                                }
                                selectedIndex = null
                            }
                        }
                ) {
                    PuzzlePieceImage(pieceId = pieceId)
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { gameOver=true
                onFinish(0) },
            colors = ButtonDefaults.buttonColors(containerColor = TextPink),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = "Surrender",
                color = White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
@Composable
fun PuzzlePieceImage(pieceId: Int) {
    val row = pieceId / 3
    val col = pieceId % 3

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clipToBounds()
    ) {
        Image(
            painter = painterResource(id = com.example.gameapplication.R.drawable.images),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    scaleX = 3f
                    scaleY = 3f
                    transformOrigin = androidx.compose.ui.graphics.TransformOrigin(0f, 0f)
                    translationX = -col * size.width
                    translationY = -row * size.height
                }
        )
    }
}