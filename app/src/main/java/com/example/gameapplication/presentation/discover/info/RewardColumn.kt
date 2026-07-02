package com.example.gameapplication.presentation.discover.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.TextPink

@Composable
fun RewardColumn(title: String, amount: String) {
    Column {
        Text(text = title, fontSize = 9.sp, color = TextPink, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = amount, fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Medium)
    }
}
