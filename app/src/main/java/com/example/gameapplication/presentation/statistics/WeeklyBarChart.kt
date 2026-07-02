package com.example.gameapplication.presentation.statistics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.TextPink

@Composable
fun WeeklyBarChart(
    scheduledCount: Int
) {
    val days = listOf("Mo", "Tu", "We", "Th", "Fr", "Sa", "Su")

    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        days.forEachIndexed { index, day ->

            val height =
                if (index < scheduledCount) {
                    (40 + index * 15).dp
                } else {
                    20.dp
                }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .width(20.dp)
                        .height(height)
                        .background(
                            TextPink,
                            RoundedCornerShape(20.dp)
                        )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = day,
                    color = Color.Gray
                )
            }
        }
    }
}