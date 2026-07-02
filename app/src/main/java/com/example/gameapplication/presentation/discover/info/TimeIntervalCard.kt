package com.example.gameapplication.presentation.discover.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.GradientBot
import com.example.uikit.theme.GradientTop
import com.example.uikit.theme.White

@Composable
fun TimeIntervalCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    listOf(
                        GradientTop,
                        GradientBot
                    )
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(20.dp)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "🕒 TIME INTERVAL", color = White,
                    fontWeight = FontWeight.Bold, fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "FROM", color = White
                            .copy(alpha = 0.7f), fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "MON, NOV 4,2019", color = White,
                        fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "TO", color = White.copy(alpha = 0.7f),
                        fontSize = 10.sp, fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "MON, NOV 4,2019", color = White,
                        fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "FROM", color = White
                            .copy(alpha = 0.7f), fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "12:30 AM", color = White,
                        fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "TO", color = White.copy(alpha = 0.7f),
                        fontSize = 10.sp, fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "3:30 AM", color = White,
                        fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}