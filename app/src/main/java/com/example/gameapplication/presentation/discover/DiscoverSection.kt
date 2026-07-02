package com.example.gameapplication.presentation.discover

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.TextPink

@Composable
fun DiscoverSection(
    title: String
) {
    Row (
        modifier = Modifier
            .fillMaxWidth( )
            .padding( 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            color = TextPink,
            fontWeight = FontWeight.Bold
        )

        Text("View All")
    }
}