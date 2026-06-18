package com.example.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.BorderGray
import com.example.uikit.theme.GradientBot
import com.example.uikit.theme.TextPink

@Composable
fun AppPagination(
    current: Int,
    total: Int
) {
    Row {
        repeat(total) { index ->
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(
                        if (index == current) GradientBot
                        else BorderGray
                    )
            )
        }
    }
}