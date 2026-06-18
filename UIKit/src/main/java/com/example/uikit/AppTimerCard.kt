package com.example.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.AppRoundedMedium
import com.example.uikit.theme.GradientBot
import com.example.uikit.theme.GradientTop
import com.example.uikit.theme.White

@Composable
fun AppTimerCard(
    time: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(AppRoundedMedium)
            .background(
                Brush.verticalGradient(
                    listOf(
                        GradientTop,
                        GradientBot
                    )
                )
            )
            .padding(24.dp)
    ) {
        Column {
            Text(
                "Timer",
                color = White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = time,
                color = White,
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}